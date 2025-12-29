# Running DevInbox Java Sample with Docker

This guide explains how to run the Java sample without installing Java or Maven locally.

## Quick Start

1. **Set your API key**:
   ```bash
   # Windows PowerShell
   $env:DEVINBOX_API_KEY='your-api-key-here'
   
   # Windows CMD
   set DEVINBOX_API_KEY=your-api-key-here
   
   # Linux/Mac
   export DEVINBOX_API_KEY=your-api-key-here
   ```

2. **Run the sample**:
   ```bash
   # Windows PowerShell
   .\run-docker.ps1
   
   # Linux/Mac/Windows Git Bash
   chmod +x run-docker.sh
   ./run-docker.sh
   ```

## Manual Docker Commands

If you prefer to run Docker commands directly:

```bash
# Build the image
docker-compose build

# Run the sample
docker-compose run --rm devinbox-java-sample
```

Or using plain Docker commands:

```bash
# Build (from the java directory)
docker build -f samples/Dockerfile -t devinbox-java-sample ..

# Run
docker run --rm -it -e DEVINBOX_API_KEY=your-api-key-here devinbox-java-sample
```

## How It Works

The Docker setup uses a multi-stage build:

1. **Builder stage**: Uses Maven to build the parent client library and the sample project
2. **Runtime stage**: Uses a lightweight JRE image with only the compiled classes and dependencies

This means:
- ✅ No Java installation needed on your machine
- ✅ No Maven installation needed
- ✅ All dependencies are bundled in the Docker image
- ✅ Fast subsequent runs (Docker caches layers)

## Troubleshooting

### Docker not found
Make sure Docker Desktop is installed and running.

### Build fails
- Ensure you're running from the `samples` directory or adjust paths accordingly
- Check that the parent project structure is correct
- Try `docker-compose build --no-cache` to rebuild from scratch

### API key not working
- Make sure the environment variable is set before running
- You can also enter it interactively when the sample prompts you

### Network issues
If you need to access localhost APIs from within Docker, the docker-compose.yml uses `network_mode: "host"` which should allow access to `localhost:5062` or `https://api.devinbox.io`.

