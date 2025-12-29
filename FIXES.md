# Known Issues and Fixes

This document tracks manual fixes that need to be applied after regenerating the Java client.

## Issue: ModelNull instead of Map<String, String>

### Problem
The OpenAPI Generator incorrectly generates `ModelNull<String, String>` for the `subject` and `body` fields in `MessageParsedViewModel` instead of `Map<String, String>`.

### Root Cause
The OpenAPI spec defines these fields with `additionalProperties` but may be missing explicit `type: object`, causing the generator to misinterpret the schema.

### Fix Required
After regenerating the client, apply the following fixes:

**1. Fix `src/main/java/io/devinbox/client/model/MessageParsedViewModel.java`:**

1. **Remove the incorrect import:**
   ```java
   // Remove this line:
   import io.devinbox.client.model.ModelNull;
   ```

2. **Replace all instances of `ModelNull<String, String>` with `Map<String, String>`:**
   - Field declarations (lines ~75, ~79)
   - Method parameters in `subject()` and `body()` methods
   - Return types in `getSubject()` and `getBody()` methods
   - Parameters in `setSubject()` and `setBody()` methods

3. **Update field declarations:**
   ```java
   // Change from:
   private ModelNull<String, String> subject = new HashMap<>();
   private ModelNull<String, String> body = new HashMap<>();
   
   // To:
   private Map<String, String> subject = new HashMap<>();
   private Map<String, String> body = new HashMap<>();
   ```

4. **Update method signatures:**
   ```java
   // Change all occurrences of:
   ModelNull<String, String>
   
   // To:
   Map<String, String>
   ```

5. **Add null checks in setters:**
   ```java
   public void setSubject(@jakarta.annotation.Nonnull Map<String, String> subject) {
       this.subject = Objects.requireNonNull(subject);
   }
   ```

**2. Fix `src/test/java/io/devinbox/client/model/MessageParsedViewModelTest.java`:**
   - Remove the unused import: `import io.devinbox.client.model.ModelNull;`

### Automated Fix Script

You can use this PowerShell script to apply the fix automatically:

```powershell
$file = "src/main/java/io/devinbox/client/model/MessageParsedViewModel.java"
$content = Get-Content $file -Raw

# Remove ModelNull import
$content = $content -replace "import io\.devinbox\.client\.model\.ModelNull;\r?\n", ""

# Replace ModelNull<String, String> with Map<String, String>
$content = $content -replace "ModelNull<String, String>", "Map<String, String>"

Set-Content $file $content
Write-Host "Fix applied to MessageParsedViewModel.java"
```

### Future Solution
To permanently fix this, we should update the OpenAPI spec generation in the C# API to explicitly include `type: object` for dictionary/map properties. This would require changes to the API's OpenAPI generation configuration.

