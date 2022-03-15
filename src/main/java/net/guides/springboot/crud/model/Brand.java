package net.guides.springboot.crud.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Boolean isApi;

	private String name;

	private String image;

	@OneToMany()
	@JoinTable(name = "categories")
	private List<CategoryEntity> categories;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "base_link_id")
	private Link baseCategoryLink;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "single_link_id")
	private Link singleCategoryLink;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_link_id")
	private Link productCategoryLink;
}
