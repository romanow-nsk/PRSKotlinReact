package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAStudent:Entity{
    var SAGroup:EntityLink<SAGroup> = EntityLink<SAGroup>()
    var User:EntityLink<User> = EntityLink<User>()
    var state:Int=0
    constructor() {}
}
