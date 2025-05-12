== User Interface Modeling using Composite Pattern
User interfaces are modeled using a tree.
The root of the tree is the entire window.
Leaf nodes represent concrete user interface elements like buttons, textboxes and so on, 
while internal nodes represent containers of other user interfaces elements.
Containers often are responsible for determining the size and positioning of their child elements.
Containers calculate the positions of their children as offsets from the container's origin, 
the size of each children depends on the total size of the container.
Each container type have a specific algorithm for defining the locations and sizes of their children.
For example, a container type can layout its children in a grid.
Another can lay them out in either a row or a column.

User interfaces are constructed by putting UI elements in these containers, 
and then composing these containers to form a tree.
This allows creating complex user interfaces that can handling resizing and layout efficiently.
The Composite pattern is the ideal pattern to model this type of composition.

== Abstract Iteration through User Interface Tree Using Iterator Pattern
== Define Exporters using Visitor Pattern
== Share Resources using Flyweight Pattern
== Building a User Interface using Builder Pattern
== Managing Global User Interface Properties using Singleton Pattern

