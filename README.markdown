# Modular Design Studio

A cross-platform UI designer implementing design patterns for the CSC-427 Term Project.

## Patterns Implemented
- **Singleton**: `ThemeManager.java`
- **Factory Method**: `ComponentFactory.java`
- **Abstract Factory**: `AbstractUIFactory.java`, `WindowsUIFactory.java`, `MacUIFactory.java`
- **Builder**: `UIBuilder.java`, `PanelBuilder.java`
- **Prototype**: `UIComponent.java`, `Panel.java`, `Button.java`, `Textbox.java`, `Dropdown.java`
- **Flyweight**: `Style.java`, `StyleFactory.java`
- **Composite**: `Panel.java`, `Button.java`, `Textbox.java`, `Dropdown.java`
- **Visitor**: `Visitor.java`, `XMLExportVisitor.java`
- **Iterator**: `PanelIterator.java`

## Running on Replit
1. Create a new Repl at [replit.com](https://replit.com) with "Java" as the language.
2. Add a `pom.xml` file for Maven dependencies:
   ```xml
   <project>
       <modelVersion>4.0.0</modelVersion>
       <groupId>com.example</groupId>
       <artifactId>modular-design-studio</artifactId>
       <version>1.0</version>
       <dependencies>
           <dependency>
               <groupId>org.openjfx</groupId>
               <artifactId>javafx-controls</artifactId>
               <version>17</version>
           </dependency>
       </dependencies>
       <build>
           <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>3.8.1</version>
                   <configuration>
                       <source>17</source>
                       <target>17</target>
                   </configuration>
               </plugin>
           </plugins>
       </build>
   </project>
   ```
3. Upload all `.java` files to the `src/main/java/modular/design/studio/` directory.
4. Run the Repl. The JavaFX GUI should appear.
5. Interact:
   - Select a theme (Windows/Mac).
   - Add Button, Textbox, or Dropdown.
   - Click components: Buttons show a message, Textboxes open a TextField, Dropdowns show a ComboBox.
   - Drag components to reposition.
   - Clone UI, export XML, or clear canvas.

## Running Locally
1. Install JDK 17+ and JavaFX SDK from [openjfx.io](https://openjfx.io).
2. Place all `.java` files in `src/main/java/modular/design/studio/`.
3. Use the `pom.xml` above or compile with:
   ```bash
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls -d . *.java
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls modular.design.studio.ModularDesignStudio
   ```
4. Interact as above.

## Troubleshooting
- **JavaFX Not Found**: Ensure JavaFX is in the module path or use Maven.
- **Components Not Clickable**: Click the rectangle directly.
- **Replit Issues**: Restart the Repl or check Maven dependencies.