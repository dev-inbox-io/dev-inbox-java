#!/bin/bash
# Bash script to apply known fixes after regenerating the Java client
# Run this script after running the OpenAPI Generator

echo "Applying fixes to generated Java client..."

MESSAGE_PARSED_VIEW_MODEL_FILE="src/main/java/io/devinbox/client/model/MessageParsedViewModel.java"

if [ ! -f "$MESSAGE_PARSED_VIEW_MODEL_FILE" ]; then
    echo "Error: $MESSAGE_PARSED_VIEW_MODEL_FILE not found!"
    echo "Make sure you're running this script from the java directory."
    exit 1
fi

echo "Fixing MessageParsedViewModel.java..."

# Remove ModelNull import
sed -i.bak '/import io\.devinbox\.client\.model\.ModelNull;/d' "$MESSAGE_PARSED_VIEW_MODEL_FILE"

# Replace ModelNull<String, String> with Map<String, String>
sed -i.bak 's/ModelNull<String, String>/Map<String, String>/g' "$MESSAGE_PARSED_VIEW_MODEL_FILE"

# Clean up backup file
rm -f "${MESSAGE_PARSED_VIEW_MODEL_FILE}.bak"

# Fix test file
TEST_FILE="src/test/java/io/devinbox/client/model/MessageParsedViewModelTest.java"
if [ -f "$TEST_FILE" ]; then
    echo "Fixing MessageParsedViewModelTest.java..."
    sed -i.bak '/import io\.devinbox\.client\.model\.ModelNull;/d' "$TEST_FILE"
    rm -f "${TEST_FILE}.bak"
fi

echo "✅ Fixes applied successfully!"
echo ""
echo "You can now build the project with: mvn clean install"

