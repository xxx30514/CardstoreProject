package cardstore.pojo;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Product {
    private Integer prodId;

    private String prodName;

    private Double prodPrice;

    private Integer prodStock;

    private String prodImg;

    private Integer prodSalecount;

    private Integer prodType;

    private Integer prodStatus;

    private LocalDateTime prodAddtime;
    
    
    
	public Product(Integer prodId, String prodName, Double prodPrice, Integer prodStock, String prodImg,
			Integer prodSalecount, Integer prodType, Integer prodStatus, LocalDateTime prodAddtime) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodImg = prodImg;
		this.prodSalecount = prodSalecount;
		this.prodType = prodType;
		this.prodStatus = prodStatus;
		this.prodAddtime = prodAddtime;
	}



	public Product(String prodName, Double prodPrice, Integer prodStock, String prodImg, Integer prodSalecount,
			Integer prodType, Integer prodStatus, LocalDateTime prodAddtime) {
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodImg = prodImg;
		this.prodSalecount = prodSalecount;
		this.prodType = prodType;
		this.prodStatus = prodStatus;
		this.prodAddtime = prodAddtime;
	}


	public Product() {
	}

    
   
}