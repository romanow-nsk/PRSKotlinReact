package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class BugMessage:Entity{
    var user:EntityLink<User> = EntityLink<User>()
    var date:OwnDateTime=OwnDateTime()
    var message:String=""
    constructor() {}
}
