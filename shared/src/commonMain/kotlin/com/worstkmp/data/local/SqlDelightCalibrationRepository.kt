package com.worstkmp.data.local

import app.cash.sqldelight.coroutines.asFlow
import com.worstkmp.WorstDatabase
import com.worstkmp.domain.model.Calibration
import com.worstkmp.domain.model.MapPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SqlDelightCalibrationRepository(
    private val database: WorstDatabase
) : CalibrationRepository {

    private val queries = database.worstDatabaseQueries   // This should work now

    override fun getAllCalibrations(): Flow<List<Calibration>> {
        return queries.selectAllCalibrations()
            .asFlow()
            .map { result ->
                result.executeAsList().map { row ->
                    Calibration(
                        id = row.id,
                        pdfFileName = row.pdfFileName,
                        point1 = MapPoint(
                            pdfX = row.point1X.toFloat(),
                            pdfY = row.point1Y.toFloat(),
                            realLat = row.point1Lat,
                            realLon = row.point1Lon
                        ),
                        point2 = MapPoint(
                            pdfX = row.point2X.toFloat(),
                            pdfY = row.point2Y.toFloat(),
                            realLat = row.point2Lat,
                            realLon = row.point2Lon
                        ),
                        point3 = MapPoint(
                            pdfX = row.point3X.toFloat(),
                            pdfY = row.point3Y.toFloat(),
                            realLat = row.point3Lat,
                            realLon = row.point3Lon
                        ),
                        lastUpdated = row.lastUpdated
                    )
                }
            }
    }

    override fun getLatestCalibration(): Flow<Calibration?> {
        return queries.selectLatestCalibration()
            .asFlow()
            .map { result ->
                val row = result.executeAsOneOrNull()   // Returns null if no rows
                if (row == null) {
                    null
                } else {
                    Calibration(
                        id = row.id,
                        pdfFileName = row.pdfFileName,
                        point1 = MapPoint(row.point1X.toFloat(), row.point1Y.toFloat(), row.point1Lat, row.point1Lon),
                        point2 = MapPoint(row.point2X.toFloat(), row.point2Y.toFloat(), row.point2Lat, row.point2Lon),
                        point3 = MapPoint(row.point3X.toFloat(), row.point3Y.toFloat(), row.point3Lat, row.point3Lon),
                        lastUpdated = row.lastUpdated
                    )
                }
            }
    }

    override suspend fun saveCalibration(calibration: Calibration): Long = TODO()
    override suspend fun deleteCalibration(id: Long) = TODO()

    override fun getCalibrationByID(id: Long): Flow<Calibration?> {
        return queries.selectCalibrationByID(id)
            .asFlow()
            .map {
                result ->
                val row = result.executeAsOneOrNull() //null if no rows
                if(row == null) {
                    null
                } else {
                    Calibration(
                        id = row.id,
                        pdfFileName = row.pdfFileName,
                        point1 = MapPoint(row.point1X.toFloat(), row.point1Y.toFloat(), row.point1Lat, row.point1Lon),
                        point2 = MapPoint(row.point2X.toFloat(), row.point2Y.toFloat(), row.point2Lat, row.point2Lon),
                        point3 = MapPoint(row.point3X.toFloat(), row.point3Y.toFloat(), row.point3Lat, row.point3Lon),
                        lastUpdated = row.lastUpdated
                    )
                }
            }
    }
}