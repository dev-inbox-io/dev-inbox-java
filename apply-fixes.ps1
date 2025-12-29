# PowerShell script to apply known fixes after regenerating the Java client
# Run this script after running the OpenAPI Generator

Write-Host "Applying fixes to generated Java client..." -ForegroundColor Cyan

$messageParsedViewModelFile = "src/main/java/io/devinbox/client/model/MessageParsedViewModel.java"

if (-not (Test-Path $messageParsedViewModelFile)) {
    Write-Host "Error: $messageParsedViewModelFile not found!" -ForegroundColor Red
    Write-Host "Make sure you're running this script from the java directory." -ForegroundColor Yellow
    exit 1
}

Write-Host "Fixing MessageParsedViewModel.java..." -ForegroundColor Green

$content = Get-Content $messageParsedViewModelFile -Raw

# Remove ModelNull import
$content = $content -replace "import io\.devinbox\.client\.model\.ModelNull;\r?\n", ""

# Replace ModelNull<String, String> with Map<String, String>
$content = $content -replace "ModelNull<String, String>", "Map<String, String>"

# Ensure Objects.requireNonNull is used in setters
$content = $content -replace 'public void setSubject\(@jakarta\.annotation\.Nonnull Map<String, String> subject\) \{', "public void setSubject(@jakarta.annotation.Nonnull Map<String, String> subject) {`n    this.subject = Objects.requireNonNull(subject);"
$content = $content -replace 'public void setBody\(@jakarta\.annotation\.Nonnull Map<String, String> body\) \{', "public void setBody(@jakarta.annotation.Nonnull Map<String, String> body) {`n    this.body = Objects.requireNonNull(body);"

Set-Content $messageParsedViewModelFile $content -NoNewline

# Fix test file
$testFile = "src/test/java/io/devinbox/client/model/MessageParsedViewModelTest.java"
if (Test-Path $testFile) {
    Write-Host "Fixing MessageParsedViewModelTest.java..." -ForegroundColor Green
    $testContent = Get-Content $testFile -Raw
    $testContent = $testContent -replace "import io\.devinbox\.client\.model\.ModelNull;\r?\n", ""
    Set-Content $testFile $testContent -NoNewline
}

Write-Host "✅ Fixes applied successfully!" -ForegroundColor Green
Write-Host ""
Write-Host "You can now build the project with: mvn clean install" -ForegroundColor Cyan

