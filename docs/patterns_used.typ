#image("full.png")
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
#image("component.png")

== Abstract Iteration through User Interface Tree Using Iterator Pattern
While modeling user interfaces, it's sufficient to use a tree-based model.
However, there are situations were iteration through all or part of the model is necessary.
The iterator pattern allows abstracting the process of looping through the model.
Other parts of the software need not know the internal structure of the user interface model in order to iterate through it.
It is necessary for the iterator to return components in a well-defined sequence (often a pre-order traversal of the tree).

== Define Exporters using Visitor Pattern
#grid(
  columns: (4fr, 1fr),
  gutter: 4em, 
  [
  The Visitor pattern is used to encapsulate the logic of exporting the user interface into a file.
  The visitor pattern isolates the logic that operates on the UI model from the representation of the model.
  This isolation allows extending the code that operates on the UI model, while keeping the UI model code simple and easy to maintain.
  For each file type that's targeted, there's a concrete visitor class that implements exporting to that file type.
  ],
  image("exporter.png") 
)

== Share Resources using Flyweight Pattern
Designing user interfaces needs resources like fonts, icons and images.
The flyweight pattern is used to represent these resources.
This allows efficient use of memory.
Assets are represented as an object per asset,
and UI elements refer to that instance of the asset in order to render itself.

== Building a User Interface using Builder Pattern
User interfaces are often a large and complex tree of components and containers.
Therefore, the builder pattern is used to encapsulate the logic of building a UI tree.
The builder is used to read a UI design from a save file.
Using the builder pattern allows the logic of building a UI and the representation of the UI to vary independently.
