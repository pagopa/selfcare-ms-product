locals {
  github = {
    org        = "pagopa"
    repository = "selfcare-ms-product"
  }

  prefix         = "selc"
  domain         = "ms-product"
  location_short = "weu"
  location       = "westeurope"
  project        = "${var.prefix}-${var.env_short}"

  app_name = "github-${local.github.org}-${local.github.repository}-${var.prefix}-${local.domain}-${var.env}"

  container_app_selc_environment = {
    name           = "${local.prefix}-${var.env_short}-cae",
    resource_group = "${local.prefix}-${var.env_short}-container-app-rg",
  }

  functions = {
    resource_group_name = "${local.prefix}-${var.env_short}-functions-rg",
    insights_key        = "${local.prefix}-${var.env_short}-appinsights"
  }

}

variable "env" {
  type = string
}

variable "env_short" {
  type = string
}

variable "prefix" {
  type    = string
  default = "selc"
  validation {
    condition = (
    length(var.prefix) <= 6
    )
    error_message = "Max length is 6 chars."
  }
}

variable "github_repository_environment" {
  type = object({
    protected_branches     = bool
    custom_branch_policies = bool
    reviewers_teams        = list(string)
  })
  description = "GitHub Continuous Integration roles"
  default     = {
    protected_branches     = false
    custom_branch_policies = true
    reviewers_teams        = ["selfcare-contributors"]
  }
}

variable "environment_roles" {
  type = object({
    subscription = list(string)
  })
  description = "GitHub Continous Integration roles"
}