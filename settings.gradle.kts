pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyNewsApp"
include(":app")
include(":feature")
include(":library")
include(":feature:home")
include(":library:network")
include(":feature:bookmark")
include(":library:common")
include(":feature:onboarding")
include(":library:utility")
include(":feature:search")
