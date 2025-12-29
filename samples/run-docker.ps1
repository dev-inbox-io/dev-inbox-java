# PowerShell script to run DevInbox Java sample using Docker

Write-Host "DevInbox Java Client - Docker Sample Runner" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Check if API key is set
if (-not $env:DEVINBOX_API_KEY) {
    Write-Host "[!] DEVINBOX_API_KEY environment variable is not set." -ForegroundColor Yellow
    Write-Host "Please set it before running:" -ForegroundColor Yellow
    Write-Host "  `$env:DEVINBOX_API_KEY='your-api-key-here'" -ForegroundColor Yellow
    Write-Host ""
    $apiKey = Read-Host "Enter your API key (or press Ctrl+C to cancel)"
    $env:DEVINBOX_API_KEY = $apiKey
}

Write-Host "[*] Building Docker image..." -ForegroundColor Green
docker-compose build

Write-Host ""
Write-Host "[*] Running sample..." -ForegroundColor Green
docker-compose run --rm devinbox-java-sample

