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
