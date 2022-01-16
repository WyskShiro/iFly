package will.shiro.ifly.flight.domain.entity

data class Itinerary(
    val legs: List<Leg>,
    val agentUrl: String,
    val price: String
)