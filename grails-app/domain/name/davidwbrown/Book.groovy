package name.davidwbrown

class Book {

    String title
    String author

    static constraints = {
        title(blank:false)
        author(blank:false)
    }
}
