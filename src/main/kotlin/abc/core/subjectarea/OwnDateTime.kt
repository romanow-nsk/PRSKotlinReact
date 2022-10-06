package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class OwnDateTime{
    var timeInMS:Long=0
    constructor() {}
}
