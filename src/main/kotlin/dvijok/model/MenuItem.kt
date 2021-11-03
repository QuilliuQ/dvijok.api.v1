package dvijok.model

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.transactions.transaction


data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val image: String
)

object Menu : IntIdTable(){
    val name = varchar("name",50)
    val description = varchar("description",200)
    val image = varchar("image",100)
}

class MenuDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MenuDao>(Menu)

    var name by Menu.name
    var description by Menu.description
    var image by Menu.image

    fun toMenuItem():MenuItem{
        return MenuItem(
            id.value,
            name,
            description,
            image
        )
    }
}


