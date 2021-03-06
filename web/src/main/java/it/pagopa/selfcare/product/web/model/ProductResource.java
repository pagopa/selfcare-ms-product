package it.pagopa.selfcare.product.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import it.pagopa.selfcare.product.connector.model.PartyRole;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.EnumMap;

@Data
public class ProductResource {

    @ApiModelProperty(value = "${swagger.product.model.id}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String id;

    @ApiModelProperty(value = "${swagger.product.model.identityTokenAudience}")
    private String identityTokenAudience;

    @ApiModelProperty(value = "${swagger.product.model.logo}")
    private String logo;

    @ApiModelProperty(value = "${swagger.product.model.logoBgColor}")
    @Pattern(regexp = "^#[0-9A-F]{6}$")
    private String logoBgColor;

    @ApiModelProperty(value = "${swagger.product.model.depictImageUrl}")
    private String depictImageUrl;

    @ApiModelProperty(value = "${swagger.product.model.title}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String title;

    @ApiModelProperty(value = "${swagger.product.model.description}")
    private String description;

    @ApiModelProperty("${swagger.product.model.urlPublic}")
    private String urlPublic;

    @ApiModelProperty(value = "${swagger.product.model.urlBO}")
    private String urlBO;

    @ApiModelProperty(value = "${swagger.product.model.creationDateTime}", required = true)
    @JsonProperty(required = true)
    @NotNull
    private OffsetDateTime createdAt;

    @ApiModelProperty(value = "${swagger.product.model.contractTemplateUpdateDateTime}", required = true)
    @JsonProperty(required = true)
    @NotNull
    private OffsetDateTime contractTemplateUpdatedAt;

    @ApiModelProperty(value = "${swagger.product.model.roleMappings}")
    private EnumMap<PartyRole, ProductRoleInfo> roleMappings;

    @ApiModelProperty(value = "${swagger.product.model.contractTemplatePath}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String contractTemplatePath;

    @ApiModelProperty(value = "${swagger.product.model.contractTemplateVersion}", required = true)
    @JsonProperty(required = true)
    @NotBlank
    private String contractTemplateVersion;

    @ApiModelProperty(value = "${swagger.product.model.roleManagementURL}", required = false)
    private String roleManagementURL;

    @ApiModelProperty(value = "${swagger.product.model.parentProduct}")
    private String parentId;

}
