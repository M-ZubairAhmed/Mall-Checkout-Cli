# Mall-Checkout-System

Java program for garment mall checkout

### Objective

This program is in response to problem statement no.1 in Xtreme Mobile organised
by Thoughtworks hyderabad

### Problem statement

Discounts on apparel This shopping season you are having fun at the Mall. The
Mall owner, himself, is quite stressed out having to manage the influx of
customers. He is struggling to calculate the discounts that he has on his
clothing line. You decide to help him out by building a system that calculates
the discounts on all the applicable items a customer has bought.

There are several categories of products. In fact, categories have subcategories
which themselves can have subcategories. Below is a diagram. Casuals is a
subcategory of Trousers, which by itself is a subcategory of Men's wear. Some
categories have discounts.

            Men's wear                 Women's wear (50% off)
            |- Shirts                  |- Dresses
            |- Trousers                |- Footwear
            |- Casuals (30% off)
            |- Jeans   (20% off)

Each product you have belongs to a brand which by themselves are running
discounts. Below is a table that lists them: Brands Discounts: Wrangler 10%
Arrow 20% Vero Moda 60% UCB None Adidas 5% Provogue 20%

This way, a product can have three types of discounts applicable:

1. Discount on the brand
2. Discount on the category
3. Discount on the ancestor category (e.g. Footwear doesn't have a discount, but
   it's parent category Women's wear has 50% off). It is worth noting, that it
   is an ancestor: not just a direct parent, anyone in the lineage.

The discount that is applied is the greatest of the above three. For example, if
the customer buys a Jeans of Wrangler Brand, the discounts are:

1. Discount on brand: 10%
2. Discount on category (Jeans): 20%
3. Discount on parents (Trousers, Men's wear): None So, the discount that is
   applied 20%.

# Inventory (the list of items that shop has):

# Id | Brand | Category | Price | Discounted Price |

1 | Arrow | Shirts | 800 | 640 | 2 | Vero Moda | Dresses | 1400 | 560 | 3 |
Provogue | Footwear | 1800 | 900 | 4 | Wrangler | Jeans | 2200 | 1760 | 5 | UCB
| Shirts | 1500 | 1500 |
===========================================================

You will be given the above table (without discounted price) in CSV form as
standard input. This is the shop inventory. You'll also get the customer options
as comma separated Id's after a newline. In the example below, 1,2,3,4 are the
customer choices.

Sample Input:

```bash
5
1, Arrow,Shirts,800
2, Vero Moda,Dresses,1400
3, Provogue,Footwear,1800
4, Wrangler,Jeans,2200
5, UCB,Shirts,1500

2
1,2,3,4
1,5

output:
3860
2140
```
