package io.renren.modules.homePage.entity;

import io.renren.modules.generator.entity.KYwMuneEntity;
import lombok.Data;

import java.util.List;


@Data
public class HomePageEntity {

    private KYwMuneEntity parentEntity;

    private List<KYwMuneEntity> childList;
}
