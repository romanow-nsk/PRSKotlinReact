package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SATeacher:Entity{
    var user:EntityLink<User> = EntityLink<User>()
    var ratings:ArrayList<EntityLink<SAGroupRating>> = ArrayList<EntityLink<SAGroupRating>>()
    constructor() {}
}
