package com.worstkmp.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.db.QueryResult
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

    override suspend fun saveCalibration(calibration: Calibration): Unit {
        queries.insertCalibration(
            pdfFileName = calibration.pdfFileName,
            point1X = calibration.point1.pdfX.toDouble(),
            point1Y = calibration.point1.pdfY.toDouble(),
            point1Lat = calibration.point1.realLat,
            point1Lon = calibration.point1.realLon,
            point2X = calibration.point2.pdfX.toDouble(),
            point2Y = calibration.point2.pdfY.toDouble(),
            point2Lat = calibration.point2.realLat,
            point2Lon = calibration.point2.realLon,
            point3X = calibration.point3.pdfX.toDouble(),
            point3Y = calibration.point3.pdfY.toDouble(),
            point3Lat = calibration.point3.realLat,
            point3Lon = calibration.point3.realLon,
            lastUpdated = calibration.lastUpdated
        )
    }

    override suspend fun deleteCalibration(id: Long) {
        queries.deleteCalibration(id)
    }

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