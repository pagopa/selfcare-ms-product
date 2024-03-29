package it.pagopa.selfcare.product.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import it.pagopa.selfcare.commons.base.utils.InstitutionType;
import it.pagopa.selfcare.product.connector.model.PartyRole;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.EnumMap;
import java.util.Map;

@Data
public class UpdateProductDto {

    @ApiModelProperty(value = "${swagger.product.model.title}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String title;

    @ApiModelProperty(value = "${swagger.product.model.description}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String description;

    @ApiModelProperty(value = "${swagger.product.model.logoBgColor}", example = "#000000")
    @Pattern(regexp = "^#[0-9A-F]{6}$")
    private String logoBgColor;

    @ApiModelProperty(value = "${swagger.product.model.identityTokenAudience}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String identityTokenAudience;

    @ApiModelProperty(value = "${swagger.product.model.urlPublic}", required = true)
    private String urlPublic;

    @ApiModelProperty(value = "${swagger.product.model.urlBO}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String urlBO;

    @ApiModelProperty(value = "${swagger.product.model.roleMappings}", required = true)
    @JsonProperty(required = true)
    @NotEmpty
    @Valid
    private EnumMap<PartyRole, ProductRoleInfo> roleMappings;

    @ApiModelProperty(value = "${swagger.product.model.contractTemplatePath}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String contractTemplatePath;

    @ApiModelProperty(value = "${swagger.product.model.contractTemplateVersion}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String contractTemplateVersion;

    @ApiModelProperty(value = "${swagger.product.model.institutionContractMappings}")
    @Valid
    private Map<InstitutionType, ContractResource> institutionContractMappings;

    @ApiModelProperty(value = "${swagger.product.model.backOfficeEnvironmentConfigurations}")
    @Valid
    private Map<String, BackOfficeConfigurationsResource> backOfficeEnvironmentConfigurations;

}
