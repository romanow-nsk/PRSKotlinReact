package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAMessage:Entity{
    var text:String=""
    var artifact:EntityLink<Artifact> = EntityLink<Artifact>()
    var sendTime:OwnDateTime=OwnDateTime()
    var author:EntityLink<User> = EntityLink<User>()
    constructor() {}
}
