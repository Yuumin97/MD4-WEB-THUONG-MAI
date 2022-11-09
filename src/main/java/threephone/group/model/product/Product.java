package threephone.group.model.product;

import threephone.group.model.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private String description;
    private String manufacture;
    private String image;
    @ManyToOne
    private Category category;
    public Product() {
    }

    public Product(Long id, String name, float price, String description, String manufacture, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(Long id, String name, float price, String description, String manufacture, String image, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
