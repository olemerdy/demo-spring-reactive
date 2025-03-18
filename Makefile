build: ## Run the Gradle build, including test suite
	@echo "Running the Gradle build, including test suite"
	gradle build

clean: ## Clean the build files
	@echo "Cleaning the build files"
	gradle clean

help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: build build-image clean help
.DEFAULT_GOAL := help