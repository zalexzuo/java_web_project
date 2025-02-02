package com.group1project.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="product")
public class Product implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="account_id")
	private Account account;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "product",cascade = CascadeType.REMOVE)
	@JsonIgnore
	@ToString.Exclude
	private List<ProductComment> comments;
	
	@Column(name="product_name", nullable = false)
	private String productName;
	
	@Column(name="product_status")
	private String status;
	
	@Column(name="product_area")
	private String productArea;
	
	@Column(name="product_simple_description" ,columnDefinition = "nvarchar(50)")
	private String productSimpleDescription;
	
	@Column(name="product_description",columnDefinition = "nvarchar(300)")
	private String productDescription;
	
	
	@Column(name="product_price", nullable = false)
	private int productPrice;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date", columnDefinition="date") // 預設是 datetime2
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date", columnDefinition="date") // 預設是 datetime2
	private Date endDate;
	
	@JsonIgnore
	@Column(name="product_pic" ,columnDefinition = "varbinary(max)")
	private byte[] productPic;
	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") // Spring MVC 用
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time", columnDefinition="datetime") // 預設是 datetime2
	private Date updatedTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private List<OrderDetail> detail;
	
	// 檢查是否有時間，沒有的話依照現在時間產生
		@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，觸發此方法
		public void onCreate() {
			if(updatedTime == null) {
				this.updatedTime = new Date();
			}
		}
		
	//當json轉換為OrderDetail時，product屬性可以只寫productId，範例:{"product":5,"date":"2020-06-23","totalDays":15}
	@JsonCreator
	public Product(Integer product) {
		this.productId = product;
	}
	

	
}
