package will.shiro.ifly.flight.data.mapper

import org.junit.Before
import org.junit.Test
import will.shiro.ifly.flight.data.entity.ApiLeg
import will.shiro.ifly.flight.domain.entity.Leg
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LegMapperTest {

    private lateinit var legMapper: LegMapper

    @Before
    fun setUp() {
        legMapper = LegMapper()
    }

    @Test
    fun `When toDomain called with valid ApiLeg Then assert it returns Leg`() {
        // Given
        val apiLeg = ApiLeg(
            airlineId = "leg_1",
            airlineName = "easyJet",
            departureTime = "2020-11-03T10:30",
            arrivalTime = "2020-11-04T06:55",
            departureAirport = "SFO",
            arrivalAirport = "FRA",
            stops = 2,
            durationMins = 630
        )

        // When
        val result = legMapper.toDomain(apiLeg)

        // Then
        val expected = Leg(
            airlineId = "leg_1",
            airlineName = "easyJet",
            departureTime = "10:30",
            arrivalTime = "06:55",
            departureAirport = "SFO",
            arrivalAirport = "FRA",
            stops = 2,
            duration = "10h 30m"
        )

        assertEquals(expected, result)
    }

    @Test
    fun `When toDomain called with invalid ApiLeg Then assert it returns null`() {
        // Given
        val apiLeg = ApiLeg(
            airlineId = null,
            airlineName = null,
            departureTime = null,
            arrivalTime = null,
            departureAirport = null,
            arrivalAirport = null,
            stops = 2,
            durationMins = 630
        )

        // When
        val result = legMapper.toDomain(apiLeg)

        // Then
        assertNull(result)
    }
}