# 2. Algorithms & Pseudocode (LLD)

## Algorithm: Add Item to Cart
BEGIN
IF item exists in cart THEN
  increase quantity
ELSE
  add item with quantity = 1
END IF
SAVE cart
END

## Algorithm: Apply Coupon
BEGIN
IF coupon exists AND valid THEN
  IF cart total >= minimum order THEN
    apply discount
  ELSE
    show error
  END IF
ELSE
  show invalid coupon message
END
