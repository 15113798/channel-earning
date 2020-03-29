package io.renren.modules.act.entity;

import io.renren.modules.generator.entity.KYwProductActionEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import lombok.Data;

import java.util.List;


@Data
public class ActProductDto {

    private List<KYwProductEntity> productEntityList;

    private KYwProductActionEntity productActionEntity;

}
