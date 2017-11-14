# NewYorkTimesBestSellers

Goal: Display a list of books from the New York Time's Best Sellers list using Dagger 2 and the new Architecture components 

# REQUIREMENTS:
1. The New York Times books_api documentation here: https://developer.nytimes.com/
2. Architecture Components documentation here: https://developer.android.com/topic/libraries/architecture/index.html
3. Dagger 2 documentation here: https://google.github.io/dagger/
4. Databinding documentation: https://developer.android.com/topic/libraries/data-binding/index.html

Add below snppet to your app.gradle file to enable DataBinding
```
android {
    ....
    dataBinding {
        enabled = true
    }
}

```

 
# FUTURE UPDATES:
1. Muilti catagory support
2. Add ROOM for offline usage.
3. RXjava 2
4. Unit Tests
5. UI update
6. Add Kotlin

# Known Bug
The app crashes due to a NPE: The NPE is caused by an injection error by dagger 2:

Possible solutions 
 1. https://google.github.io/dagger//android.html
 2. https://stackoverflow.com/questions/44651278/how-to-properly-use-dagger2-with-the-new-android-architecture-components
 3. https://stackoverflow.com/questions/44270577/android-lifecycle-library-viewmodel-using-dagger-2
 4. [Unlikely But Possible] Retrofit: incorrect netwrok request. Check that you have the headers right & the JSON to POJO model is correct
 

