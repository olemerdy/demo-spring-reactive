build: ## Run the Gradle build, including test suite
	@echo "Running the Gradle build, including test suite"
	gradle build

build-image: build ## Run the Docker image build
	@echo "Running the Docker image build"
	@gradle bootBuildImage

clean: ## Clean the build files
	@echo "Cleaning the build files"
	gradle clean

start: ## Start the application
	@echo "Starting the application"
	@gradle bootRun

test: ## Test the application
	@echo "Test the application"
	@gradle check testCodeCoverageReport

help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: build build-image clean start help
.DEFAULT_GOAL := help