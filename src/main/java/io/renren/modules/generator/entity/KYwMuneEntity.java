package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-19 14:20:37
 */
@Data
@TableName("k_yw_mune")
public class KYwMuneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 父级id，顶级用0
	 */
	private Integer pid;
	/**
	 * 标题
	 */
	private String name;
	/**
	 * logo路径
	 */
	private String logoUrl;
	/**
	 * 标题说明
	 */
	private String titleContent;
	/**
	 * 请求路径
	 */
	private String requestPath;
	/**
	 * 类型 1首页顶部导航栏  2首页底部导航栏
	 */
	private Integer type;
	/**
	 * 排序
	 */
	private Integer sort;

}
