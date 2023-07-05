package it.pagopa.selfcare.product.web.model.mapper;

import it.pagopa.selfcare.product.connector.model.BackOfficeConfigurations;
import it.pagopa.selfcare.product.connector.model.PartyRole;
import it.pagopa.selfcare.product.connector.model.ProductOperations;
import it.pagopa.selfcare.product.connector.model.ProductRoleInfoOperations;
import it.pagopa.selfcare.product.web.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * It's better using sdk such as <a href="https://reflectoring.io/java-mapping-with-mapstruct/">mapstruct</a>, look at @classes ProductResourceMapper
 * */
@Deprecated
@Slf4j
public class ProductMapper {

    public static ProductResource toResource(ProductOperations entity) {
        log.trace("toResource start");
        log.debug("toResource entity = {}", entity);
        ProductResource resource = null;

        if (entity != null) {
            resource = new ProductResource();
            resource.setId(entity.getId());
            resource.setLogo(entity.getLogo());
            resource.setLogoBgColor(entity.getLogoBgColor());
            resource.setDepictImageUrl(entity.getDepictImageUrl());
            resource.setTitle(entity.getTitle());
            resource.setDescription(entity.getDescription());
            resource.setUrlPublic(entity.getUrlPublic());
            resource.setUrlBO(entity.getUrlBO());
            resource.setCreatedAt(entity.getCreatedAt());
            resource.setStatus(entity.getStatus());
            if (entity.getCreatedBy() != null) {
                resource.setCreatedBy(UUID.fromString(entity.getCreatedBy()));
            }
            resource.setModifiedAt(entity.getModifiedAt());
            if (entity.getModifiedBy() != null) {
                resource.setModifiedBy(UUID.fromString(entity.getModifiedBy()));
            }
            resource.setContractTemplateUpdatedAt(entity.getContractTemplateUpdatedAt());
            resource.setRoleMappings(toRoleMappings(entity.getRoleMappings()));
            resource.setRoleManagementURL(entity.getRoleManagementURL());
            resource.setContractTemplatePath(entity.getContractTemplatePath());
            resource.setContractTemplateVersion(entity.getContractTemplateVersion());
            resource.setIdentityTokenAudience(entity.getIdentityTokenAudience());
            resource.setBackOfficeEnvironmentConfigurations(toBackOfficeConfigurations(entity.getBackOfficeEnvironmentConfigurations()));
            if (entity.getParentId() != null) {
                resource.setParentId(entity.getParentId());
            }
        }
        log.debug("toResource result = {}", resource);
        log.trace("toResource end");
        return resource;
    }

    public static ProductOperations fromDto(CreateProductDto dto) {
        log.trace("fromDto start");
        log.debug("fromDto createProductDto = {}", dto);
        ProductOperations product = null;
        if (dto != null) {
            product = new ProductDto();
            product.setId(dto.getId());
            product.setIdentityTokenAudience(dto.getIdentityTokenAudience());
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setUrlPublic(dto.getUrlPublic());
            product.setUrlBO(dto.getUrlBO());
            product.setRoleMappings(dto.getRoleMappings());
            product.setInstitutionContractMappings(dto.getInstitutionContractMappings());
            product.setContractTemplatePath(dto.getContractTemplatePath());
            product.setContractTemplateVersion(dto.getContractTemplateVersion());
            product.setLogoBgColor(dto.getLogoBgColor());
            product.setBackOfficeEnvironmentConfigurations(dto.getBackOfficeEnvironmentConfigurations());
        }
        log.debug("fromDto result = {}", product);
        log.trace("fromDto end");
        return product;
    }

    public static ProductOperations fromDto(CreateSubProductDto dto) {
        ProductOperations product = null;
        if (dto != null) {
            product = new ProductDto();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setInstitutionContractMappings(dto.getInstitutionContractMappings());
            product.setContractTemplatePath(dto.getContractTemplatePath());
            product.setContractTemplateVersion(dto.getContractTemplateVersion());
        }
        return product;
    }

    public static ProductOperations fromDto(UpdateProductDto dto) {
        log.trace("fromDto start");
        log.debug("fromDto updateProductDto = {}", dto);
        ProductOperations product = null;
        if (dto != null) {
            product = new ProductDto();
            product.setTitle(dto.getTitle());
            product.setLogoBgColor(dto.getLogoBgColor());
            product.setIdentityTokenAudience(dto.getIdentityTokenAudience());
            product.setDescription(dto.getDescription());
            product.setUrlPublic(dto.getUrlPublic());
            product.setUrlBO(dto.getUrlBO());
            product.setRoleMappings(dto.getRoleMappings());
            product.setContractTemplatePath(dto.getContractTemplatePath());
            product.setContractTemplateVersion(dto.getContractTemplateVersion());
            product.setInstitutionContractMappings(dto.getInstitutionContractMappings());
            product.setBackOfficeEnvironmentConfigurations(dto.getBackOfficeEnvironmentConfigurations());
        }
        log.debug("fromDto result = {}", product);
        log.trace("fromDto end");
        return product;
    }

    public static ProductOperations fromDto(UpdateSubProductDto dto) {
        ProductOperations product = null;
        if (dto != null) {
            product = new ProductDto();
            product.setTitle(dto.getTitle());
            product.setContractTemplatePath(dto.getContractTemplatePath());
            product.setContractTemplateVersion(dto.getContractTemplateVersion());
            product.setInstitutionContractMappings(dto.getInstitutionContractMappings());
        }
        return product;
    }

    public static EnumMap<PartyRole, ProductRoleInfo> toRoleMappings(EnumMap<PartyRole, ? extends ProductRoleInfoOperations> roleMappings) {
        EnumMap<PartyRole, ProductRoleInfo> result;
        if (roleMappings == null) {
            result = null;
        } else {
            result = new EnumMap<>(PartyRole.class);
            roleMappings.forEach((key, value) -> result.put(key, new ProductRoleInfo(value)));
        }
        return result;
    }

    public static Map<String, BackOfficeConfigurationsResource> toBackOfficeConfigurations(Map<String, ? extends BackOfficeConfigurations> backOfficeEnvironmentConfigurations) {
        Map<String, BackOfficeConfigurationsResource> result;
        if (backOfficeEnvironmentConfigurations == null) {
            result = null;
        } else {
            result = new HashMap<>();
            backOfficeEnvironmentConfigurations.forEach((key, value) -> {
                final BackOfficeConfigurationsResource resource = new BackOfficeConfigurationsResource();
                resource.setUrl(value.getUrl());
                resource.setIdentityTokenAudience(value.getIdentityTokenAudience());
                result.put(key, resource);
            });
        }
        return result;
    }

    public static List<ProductTreeResource> toTreeResource(List<ProductOperations> model) {
        List<ProductTreeResource> resources = null;
        if (model != null) {
            Map<String, List<ProductOperations>> collect = model.stream()
                    .filter(productOperations -> productOperations.getParentId() != null)
                    .collect(Collectors.groupingBy(ProductOperations::getParentId, Collectors.toList()));
            resources = model.stream()
                    .filter(productOperations -> productOperations.getParentId() == null)
                    .map(productOperations -> {
                        ProductTreeResource productTreeResource = new ProductTreeResource();
                        productTreeResource.setNode(ProductMapper.toResource(productOperations));
                        if (collect.get(productOperations.getId()) != null) {
                            productTreeResource.setChildren(collect.get(productOperations.getId()).stream()
                                    .map(ProductMapper::toResource)
                                    .collect(Collectors.toList()));
                        }
                        return productTreeResource;
                    }).collect(Collectors.toList());
        }
        return resources;
    }

}
