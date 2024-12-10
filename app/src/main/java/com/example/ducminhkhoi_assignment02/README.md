
# Bookstore Inventory Management App

This application is designed to manage a bookstore's inventory, allowing users to add, view, edit, delete, and persist data related to books. 
The app uses Kotlin, Room Database, and View Binding.



## Setup Instructions

1. Download Zip file and Extract it.

2. Open the Project in Android Studio:


3. Build and Sync the Project:
    - Sync Gradle by selecting "File > Sync Project with Gradle Files".
    - Ensure all dependencies are downloaded.

4. Run the App:
    - Connect an emulator or a physical Android device.
    - Click the "Run" button in Android Studio to install and run the app.

5. Dependencies:
    - Ensure the following dependencies are included in the `build.gradle` (app level) file:
      ```gradle
      dependencies {
       val roomVersion = "2.6.1"

       implementation("androidx.core:core-ktx:1.12.0")
       implementation("androidx.appcompat:appcompat:1.6.1")
       implementation("com.google.android.material:material:1.11.0")
       implementation("androidx.constraintlayout:constraintlayout:2.1.4")

       // Room components
       implementation("androidx.room:room-runtime:$roomVersion")
       implementation("androidx.room:room-ktx:$roomVersion")
       ksp("androidx.room:room-compiler:$roomVersion")

       // Kotlin coroutines
       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

       implementation("androidx.recyclerview:recyclerview:1.3.2")
       implementation("androidx.cardview:cardview:1.0.0")
      }
      ```

## Implemented Features

1. Add a New Book:
    - Users can input details like the title, author, price, and quantity.
    - The book is saved to the database and displayed in the inventory list.

2. View All Books:
    - The main screen displays all books in a scrollable RecyclerView.
    - Each book shows its title, author, price, and quantity.

3. Edit a Book:
    - Users can update the details of a book by selecting it from the list.
    - Changes are saved to the database and reflected immediately.

4. Delete a Book:
    - Users can delete a book from the inventory.
    - The book is removed from both the database and the UI.

5. Data Persistence:
    - All book data is stored in a Room Database.
    - The data persists across app restarts.

6. Responsive Dialogs:
    - Input and edit dialogs are scrollable to ensure usability on all screen sizes.



## Known Issues

Input Validation:
    - Input fields currently do not validate user input for empty fields or invalid numbers.


## Future Improvements

1. Enhanced Input Validation:
    - Add checks for empty fields and invalid inputs before saving data.

2. Search and Filter Options:
    - Allow users to search for books by title or filter by author, price range, or quantity.

3. Sorting Options:
    - Enable sorting by title, price, or quantity.

4. Cloud Sync:
    - Integrate cloud storage (e.g., Firebase) for backup and multi-device synchronization.

5. LogIn / SignUp: 
    - Create user profile to save their own database.

