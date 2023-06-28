//package shoppingmall;
//
//import shoppingmall.services.productService.ProductService;
//import shoppingmall.models.Product;
//
//public class MenuProductUSer extends ProductService {
//    //function is used to filter product that base on type of product
//    public void filterProducṭ(String type) {
//        ProductService newList = this;
//
//        for (Product product : listProduct) {
//            if (product.getType().equals(type)) {
//                newList.addProduct(product);
//            }
//        }
//        if (newList.getSize() == 0) {
//            System.out.println("Không tìm thấy sản phảm mà bạn đã cung cấp thông tin");
//        }
//        else {
//            System.out.println("Có " + newList.getSize() + " saản phẩm có thông tin giống trên: ");
//            for(Product product : newList.getListProduct()){
//                product.showProduct();
//            }
//        }
//    }
//}
