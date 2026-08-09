We have a use case where:  
getCategory() has multiple implementations.
getPrice() has multiple implementations.
The getPrice() method must be called only after the getCategory() method has completed.

Design this in scalable way