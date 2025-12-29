#!/bin/bash
# Script to run DevInbox Java sample using Docker

set -e

echo "DevInbox Java Client - Docker Sample Runner"
echo "============================================"
echo ""

# Check if API key is set
if [ -z "$DEVINBOX_API_KEY" ]; then
    echo "[!] DEVINBOX_API_KEY environment variable is not set."
    echo "Please set it before running:"
    echo "  export DEVINBOX_API_KEY=your-api-key-here"
    echo ""
    read -p "Enter your API key (or press Ctrl+C to cancel): " api_key
    export DEVINBOX_API_KEY="$api_key"
fi

echo "[*] Building Docker image..."
docker-compose build

echo ""
echo "[*] Running sample..."
docker-compose run --rm devinbox-java-sample

