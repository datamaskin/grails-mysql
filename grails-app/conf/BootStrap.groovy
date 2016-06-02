import name.davidwbrown.Book
import name.davidwbrown.Role
import name.davidwbrown.User
import name.davidwbrown.UserRole

class BootStrap {

    def init = { servletContext ->
                     if (!Book.count()) {
                         new Book(author:"Stephen King", title:"The Shining").save(failOnError:true)
                         new Book(author:"James Patterson", title:"Along Came a Spider").save(failOnError:true)
                     }

                     def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
                     def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
                     
                     def adminUser = new User(username: 'admin', enabled: true, password: 'thisismypassword').save(flush: true)

                     UserRole.create adminUser, adminRole, true
    }
    def destroy = {
    }
}
