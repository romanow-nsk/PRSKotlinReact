package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class HelpFile:Entity{
    var title:String=""
    var tagList:String=""
    var itemFile:EntityLink<Artifact> = EntityLink<Artifact>()
    constructor() {}
}
