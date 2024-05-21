# Getting Started

How to run:
`./mvnw spring-boot:run`

Json to create a new product:

```
{
    "name": "Product 3",
    "price": 100,
    "variants": [
        {
            "variantType1": "color",
            "variantValue1": "blue",
            "price": 90
        },
        {
            "variantType1": "color",
            "variantValue1": "red",
            "price": 80
        }
    ]
}
```

FindByName:

/api/products/search?name={name}

Find by name and variant option (example color = "red")

/api/products/search/Product/color/red
