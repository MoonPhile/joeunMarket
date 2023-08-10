package com.joeun.service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProduct(ProductDto product) {
        productMapper.addProduct(product);
    }

    public void addCategory(ProductCategoryDto category) {
        productMapper.addCategory(category);
    }

    public List<ProductDto> findAllProduct() {
        return productMapper.findAllProduct();
    }

    public List<ProductCategoryDto> findAllCategory() {
        return productMapper.findAllCategory();
    }

    public List<ProductCategoryDto> findCategoryName(int category) {
        return productMapper.findCategoryName(category);
    }

    public String uploadFile(MultipartFile file) {
        System.out.println("이미지 업로드");
        if (file.isEmpty()) {
            return "NULL";
        }
        String origName = file.getOriginalFilename();
        String savedPath = "C:/images/" + origName;
        File dest = new File(savedPath);
        try {
            file.transferTo(dest);
            return savedPath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try{
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(savedPath+origName);
//            Files.write(path,bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
<<<<<<< HEAD
	}

	public List<ProductDto> findProductsByKeywordPaging(int offset, int size, String keyword) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}

		List<ProductDto> products = productMapper.findProductsByKeywordPaging(offset, size, keyword);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findAllProductsPaging(int offset, int size) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products =  productMapper.findAllProductsPaging(offset, size);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findProductsByKeywordPrice(int offset, int size, String keyword) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products = productMapper.findProductsByKeywordPrice(offset, size, keyword);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findAllProductsPrice(int offset, int size) { 
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products =  productMapper.findAllProductsPrice(offset, size);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findProductsByKeywordhighPaging(int offset, int size, String keyword) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products =  productMapper.findProductsByKeywordhighPaging(offset, size, keyword);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findAllProductshighPaging(int offset, int size) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products = productMapper.findAllProductshighPaging(offset, size);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findProductsByKeywordhighPrice(int offset, int size, String keyword) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products = productMapper.findProductsByKeywordhighPrice(offset, size, keyword);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findAllProductshighPrice(int offset, int size) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products = productMapper.findAllProductshighPrice(offset, size);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}

	public List<ProductDto> findProductByCategoty(int offset, int size,int category) {
		if (offset < 0) {
			offset = 0; // 음수 offset을 0으로 대체
		}
		List<ProductDto> products = productMapper.findProductByCategoty(offset, size,category);
		if (products == null) {
			return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
		}
		return products;
	}
	
	public List<Integer> findAllProductId() {
		return productMapper.findAllProductId();
	}

	public ProductDto findProductById(int productId) {
		return productMapper.findProductById(productId);
	}

	public void updateProduct(ProductDto product) {
		productMapper.updateProduct(product);
	}

	public List<ProductDto> orderproduct(String order) {
		return productMapper.orderproduct(order);

	}
	// order 관련
	public ProductDto getProductInfo(int productId) {
		return productMapper.getProductInfo(productId);
	}
=======
    }

    public List<ProductDto> findProductsByKeywordPaging(int offset, int size, String keyword) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }

        List<ProductDto> products = productMapper.findProductsByKeywordPaging(offset, size, keyword);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findAllProductsPaging(int offset, int size) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findAllProductsPaging(offset, size);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findProductsByKeywordPrice(int offset, int size, String keyword) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findProductsByKeywordPrice(offset, size, keyword);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findAllProductsPrice(int offset, int size) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findAllProductsPrice(offset, size);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findProductsByKeywordhighPaging(int offset, int size, String keyword) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findProductsByKeywordhighPaging(offset, size, keyword);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findAllProductshighPaging(int offset, int size) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findAllProductshighPaging(offset, size);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findProductsByKeywordhighPrice(int offset, int size, String keyword) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findProductsByKeywordhighPrice(offset, size, keyword);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findAllProductshighPrice(int offset, int size) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findAllProductshighPrice(offset, size);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }

    public List<ProductDto> findProductByCategory(int offset, int size, int category) {
        if (offset < 0) {
            offset = 0; // 음수 offset을 0으로 대체
        }
        List<ProductDto> products = productMapper.findProductByCategory(offset, size, category);
        if (products == null) {
            return Collections.emptyList(); // 검색 결과가 없을 때 빈 리스트 반환
        }
        return products;
    }



    public List<Integer> findAllProductId() {
        return productMapper.findAllProductId();
    }

    public ProductDto findProductById(int productId) {
        return productMapper.findProductById(productId);
    }

    public void updateProduct(ProductDto product) {
        productMapper.updateProduct(product);
    }

    public List<ProductDto> orderproduct(String order) {
        return productMapper.orderproduct(order);

    }

    // order 관련
    public ProductDto getProductInfo(int productId) {
        return productMapper.getProductInfo(productId);
    }

    public int getPriceById(int id) {
        return productMapper.getPriceById(id);
    }
>>>>>>> develop
}