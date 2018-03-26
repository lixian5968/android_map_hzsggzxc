package com.lx.android_map_hzsggzxc.utils;


import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class CoordinateUtil {
    private static double a = 6378245.0;
    private static double ee = 0.00669342162296594323;

    /**
     * 手机GPS坐标转火星坐标
     *
     * @param wgLoc
     * @return
     */
    public static LatLng transformFromWGSToGCJ(LatLng wgLoc) {

        //如果在国外，则默认不进行转换
        if (outOfChina(wgLoc.latitude, wgLoc.longitude)) {
            return new LatLng(wgLoc.latitude, wgLoc.longitude);
        }
        double dLat = transformLat(wgLoc.longitude - 105.0,
                wgLoc.latitude - 35.0);
        double dLon = transformLon(wgLoc.longitude - 105.0,
                wgLoc.latitude - 35.0);
        double radLat = wgLoc.latitude / 180.0 * Math.PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * Math.PI);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * Math.PI);

        return new LatLng(wgLoc.latitude + dLat, wgLoc.longitude + dLon);
    }

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
                + 0.2 * Math.sqrt(x > 0 ? x : -x);
        ret += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x
                * Math.PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * Math.PI) + 40.0 * Math.sin(y / 3.0
                * Math.PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * Math.PI) + 320 * Math.sin(y
                * Math.PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
                * Math.sqrt(x > 0 ? x : -x);
        ret += (20.0 * Math.sin(6.0 * x * Math.PI) + 20.0 * Math.sin(2.0 * x
                * Math.PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * Math.PI) + 40.0 * Math.sin(x / 3.0
                * Math.PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * Math.PI) + 300.0 * Math.sin(x
                / 30.0 * Math.PI)) * 2.0 / 3.0;
        return ret;
    }

    public static boolean outOfChina(double lat, double lon) {
//        if (lon < 72.004 || lon > 137.8347)
//            return true;
//        if (lat < 0.8293 || lat > 55.8271)
//            return true;
        return !CheckInChina(lat,lon);
    }


    public static List<LatLng[]> polygon = new ArrayList<LatLng[]>();

    static {
        polygon.add(new LatLng[] // Mainland
                {
                        new LatLng(27.32083, 88.91693), new LatLng(27.54243, 88.76464),
                        new LatLng(28.00805, 88.83575), new LatLng(28.1168, 88.62435),
                        new LatLng(27.86605, 88.14279), new LatLng(27.82305, 87.19275),
                        new LatLng(28.11166, 86.69527), new LatLng(27.90888, 86.45137),
                        new LatLng(28.15805, 86.19769), new LatLng(27.88625, 86.0054),
                        new LatLng(28.27916, 85.72137), new LatLng(28.30666, 85.11095),
                        new LatLng(28.59104, 85.19518), new LatLng(28.54444, 84.84665),
                        new LatLng(28.73402, 84.48623), new LatLng(29.26097, 84.11651),
                        new LatLng(29.18902, 83.5479), new LatLng(29.63166, 83.19109),
                        new LatLng(30.06923, 82.17525), new LatLng(30.33444, 82.11123),
                        new LatLng(30.385, 81.42623), new LatLng(30.01194, 81.23221),
                        new LatLng(30.20435, 81.02536), new LatLng(30.57552, 80.207),
                        new LatLng(30.73374, 80.25423), new LatLng(30.96583, 79.86304),
                        new LatLng(30.95708, 79.55429), new LatLng(31.43729, 79.08082),
                        new LatLng(31.30895, 78.76825), new LatLng(31.96847, 78.77075),
                        new LatLng(32.24304, 78.47594), new LatLng(32.5561, 78.40595),
                        new LatLng(32.63902, 78.74623), new LatLng(32.35083, 78.9711),
                        new LatLng(32.75666, 79.52874), new LatLng(33.09944, 79.37511),
                        new LatLng(33.42863, 78.93623), new LatLng(33.52041, 78.81387),
                        new LatLng(34.06833, 78.73581), new LatLng(34.35001, 78.98535),
                        new LatLng(34.6118, 78.33707), new LatLng(35.28069, 78.02305),
                        new LatLng(35.49902, 78.0718), new LatLng(35.50133, 77.82393),
                        new LatLng(35.6125, 76.89526), new LatLng(35.90665, 76.55304),
                        new LatLng(35.81458, 76.18061), new LatLng(36.07082, 75.92887),
                        new LatLng(36.23751, 76.04166), new LatLng(36.66343, 75.85984),
                        new LatLng(36.73169, 75.45179), new LatLng(36.91156, 75.39902),
                        new LatLng(36.99719, 75.14787), new LatLng(37.02782, 74.56543),
                        new LatLng(37.17, 74.39089), new LatLng(37.23733, 74.91574),
                        new LatLng(37.40659, 75.18748), new LatLng(37.65243, 74.9036),
                        new LatLng(38.47256, 74.85442), new LatLng(38.67438, 74.35471),
                        new LatLng(38.61271, 73.81401), new LatLng(38.88653, 73.70818),
                        new LatLng(38.97256, 73.85235), new LatLng(39.23569, 73.62005),
                        new LatLng(39.45483, 73.65569), new LatLng(39.59965, 73.95471),
                        new LatLng(39.76896, 73.8429), new LatLng(40.04202, 73.99096),
                        new LatLng(40.32792, 74.88089), new LatLng(40.51723, 74.8588),
                        new LatLng(40.45042, 75.23394), new LatLng(40.64452, 75.58284),
                        new LatLng(40.298, 75.70374), new LatLng(40.35324, 76.3344),
                        new LatLng(41.01258, 76.87067), new LatLng(41.04079, 78.08083),
                        new LatLng(41.39286, 78.39554), new LatLng(42.03954, 80.24513),
                        new LatLng(42.19622, 80.23402), new LatLng(42.63245, 80.15804),
                        new LatLng(42.81565, 80.25796), new LatLng(42.88545, 80.57226),
                        new LatLng(43.02906, 80.38405), new LatLng(43.1683, 80.81526),
                        new LatLng(44.11378, 80.36887), new LatLng(44.6358, 80.38499),
                        new LatLng(44.73408, 80.51589), new LatLng(44.90282, 79.87106),
                        new LatLng(45.3497, 81.67928), new LatLng(45.15748, 81.94803),
                        new LatLng(45.13303, 82.56638), new LatLng(45.43581, 82.64624),
                        new LatLng(45.5831, 82.32179), new LatLng(47.20061, 83.03443),
                        new LatLng(46.97332, 83.93026), new LatLng(46.99361, 84.67804),
                        new LatLng(46.8277, 84.80318), new LatLng(47.0591, 85.52257),
                        new LatLng(47.26221, 85.70139), new LatLng(47.93721, 85.53707),
                        new LatLng(48.39333, 85.76596), new LatLng(48.54277, 86.59791),
                        new LatLng(49.1102, 86.87602), new LatLng(49.09262, 87.34821),
                        new LatLng(49.17295, 87.8407), new LatLng(48.98304, 87.89291),
                        new LatLng(48.88103, 87.7611), new LatLng(48.73499, 88.05942),
                        new LatLng(48.56541, 87.99194), new LatLng(48.40582, 88.51679),
                        new LatLng(48.21193, 88.61179), new LatLng(47.99374, 89.08514),
                        new LatLng(47.88791, 90.07096), new LatLng(46.95221, 90.9136),
                        new LatLng(46.57735, 91.07027), new LatLng(46.29694, 90.92151),
                        new LatLng(46.01735, 91.02651), new LatLng(45.57972, 90.68193),
                        new LatLng(45.25305, 90.89694), new LatLng(45.07729, 91.56088),
                        new LatLng(44.95721, 93.5547), new LatLng(44.35499, 94.71735),
                        new LatLng(44.29416, 95.41061), new LatLng(44.01937, 95.34109),
                        new LatLng(43.99311, 95.53339), new LatLng(43.28388, 95.87901),
                        new LatLng(42.73499, 96.38206), new LatLng(42.79583, 97.1654),
                        new LatLng(42.57194, 99.51012), new LatLng(42.67707, 100.8425),
                        new LatLng(42.50972, 101.8147), new LatLng(42.23333, 102.0772),
                        new LatLng(41.88721, 103.4164), new LatLng(41.87721, 104.5267),
                        new LatLng(41.67068, 104.5237), new LatLng(41.58666, 105.0065),
                        new LatLng(42.46624, 107.4758), new LatLng(42.42999, 109.3107),
                        new LatLng(42.64576, 110.1064), new LatLng(43.31694, 110.9897),
                        new LatLng(43.69221, 111.9583), new LatLng(44.37527, 111.4214),
                        new LatLng(45.04944, 111.873), new LatLng(45.08055, 112.4272),
                        new LatLng(44.8461, 112.853), new LatLng(44.74527, 113.638),
                        new LatLng(45.38943, 114.5453), new LatLng(45.4586, 115.7019),
                        new LatLng(45.72193, 116.2104), new LatLng(46.29583, 116.5855),
                        new LatLng(46.41888, 117.3755), new LatLng(46.57069, 117.425),
                        new LatLng(46.53645, 117.8455), new LatLng(46.73638, 118.3147),
                        new LatLng(46.59895, 119.7068), new LatLng(46.71513, 119.9315),
                        new LatLng(46.90221, 119.9225), new LatLng(47.66499, 119.125),
                        new LatLng(47.99475, 118.5393), new LatLng(48.01125, 117.8046),
                        new LatLng(47.65741, 117.3827), new LatLng(47.88805, 116.8747),
                        new LatLng(47.87819, 116.2624), new LatLng(47.69186, 115.9231),
                        new LatLng(47.91749, 115.5944), new LatLng(48.14353, 115.5491),
                        new LatLng(48.25249, 115.8358), new LatLng(48.52055, 115.8111),
                        new LatLng(49.83047, 116.7114), new LatLng(49.52058, 117.8747),
                        new LatLng(49.92263, 118.5746), new LatLng(50.09631, 119.321),
                        new LatLng(50.33028, 119.36), new LatLng(50.39027, 119.1386),
                        new LatLng(51.62083, 120.0641), new LatLng(52.115, 120.7767),
                        new LatLng(52.34423, 120.6259), new LatLng(52.54267, 120.7122),
                        new LatLng(52.58805, 120.0819), new LatLng(52.76819, 120.0314),
                        new LatLng(53.26374, 120.8307), new LatLng(53.54361, 123.6147),
                        new LatLng(53.18832, 124.4933), new LatLng(53.05027, 125.62),
                        new LatLng(52.8752, 125.6573), new LatLng(52.75722, 126.0968),
                        new LatLng(52.5761, 125.9943), new LatLng(52.12694, 126.555),
                        new LatLng(51.99437, 126.4412), new LatLng(51.38138, 126.9139),
                        new LatLng(51.26555, 126.8176), new LatLng(51.31923, 126.9689),
                        new LatLng(51.05825, 126.9331), new LatLng(50.74138, 127.2919),
                        new LatLng(50.31472, 127.334), new LatLng(50.20856, 127.5861),
                        new LatLng(49.80588, 127.515), new LatLng(49.58665, 127.838),
                        new LatLng(49.58443, 128.7119), new LatLng(49.34676, 129.1118),
                        new LatLng(49.4158, 129.4902), new LatLng(48.86464, 130.2246),
                        new LatLng(48.86041, 130.674), new LatLng(48.60576, 130.5236),
                        new LatLng(48.3268, 130.824), new LatLng(48.10839, 130.6598),
                        new LatLng(47.68721, 130.9922), new LatLng(47.71027, 132.5211),
                        new LatLng(48.09888, 133.0827), new LatLng(48.06888, 133.4843),
                        new LatLng(48.39112, 134.4153), new LatLng(48.26713, 134.7408),
                        new LatLng(47.99207, 134.5576), new LatLng(47.70027, 134.7608),
                        new LatLng(47.32333, 134.1825), new LatLng(46.64017, 133.9977),
                        new LatLng(46.47888, 133.8472), new LatLng(46.25363, 133.9016),
                        new LatLng(45.82347, 133.4761), new LatLng(45.62458, 133.4702),
                        new LatLng(45.45083, 133.1491), new LatLng(45.05694, 133.0253),
                        new LatLng(45.34582, 131.8684), new LatLng(44.97388, 131.4691),
                        new LatLng(44.83649, 130.953), new LatLng(44.05193, 131.298),
                        new LatLng(43.53624, 131.1912), new LatLng(43.38958, 131.3104),
                        new LatLng(42.91645, 131.1285), new LatLng(42.74485, 130.4327),
                        new LatLng(42.42186, 130.6044), new LatLng(42.71416, 130.2468),
                        new LatLng(42.88794, 130.2514), new LatLng(43.00457, 129.9046),
                        new LatLng(42.43582, 129.6955), new LatLng(42.44624, 129.3493),
                        new LatLng(42.02736, 128.9269), new LatLng(42.00124, 128.0566),
                        new LatLng(41.58284, 128.3002), new LatLng(41.38124, 128.1529),
                        new LatLng(41.47249, 127.2708), new LatLng(41.79222, 126.9047),
                        new LatLng(41.61176, 126.5661), new LatLng(40.89694, 126.0118),
                        new LatLng(40.47037, 124.8851),
                        //start
                        new LatLng(40.09362, 124.3736),
                        //start
                        new LatLng(39.99921, 124.3693),
                        new LatLng(39.83754, 124.1736),
                        new LatLng(39.14071, 124.291),
                        new LatLng(38.3675, 123.1018),
                        new LatLng(36.62434, 124.4201),
                        new LatLng(35.021, 122.2009),
                        new LatLng(30.65681, 125.0903),
                        new LatLng(26.01236, 122.5634),
                        new LatLng(26.67936, 120.6271),
                        new LatLng(26.24169, 119.8471),
                        new LatLng(25.89876, 119.7949),
                        new LatLng(25.29188, 120.4733),
                        new LatLng(23.91094, 119.1961),
                        new LatLng(24.564352362015715, 118.47374119682456),
                        new LatLng(24.51464, 118.2774),
                        new LatLng(24.41651, 118.1764),
                        new LatLng(24.01134, 118.7951),
                        new LatLng(22.28909, 117.9931),
                        new LatLng(11.52308, 117.8833),
                        new LatLng(5.15659, 111.0937),
                        new LatLng(9.25393, 109.0722),
                        new LatLng(12.21118, 111.5332),
                        new LatLng(19.12441, 107.1936),
                        new LatLng(19.12441, 107.1936),
                        new LatLng(20.3034, 108.3336),
                        new LatLng(21.22026, 108.2447),
                        new LatLng(21.544237448637677, 108.03219537164226),
                        new LatLng(21.54063, 107.9712),
                        new LatLng(21.65242340496275, 107.86130427787454),
                        //end
                        new LatLng(21.60526, 107.3627),
                        //end
                        new LatLng(22.03083, 106.6933), new LatLng(22.45682, 106.5517),
                        new LatLng(22.76389, 106.7875), new LatLng(22.86694, 106.7029),
                        new LatLng(22.91253, 105.8771), new LatLng(23.32416, 105.3587),
                        new LatLng(23.18027, 104.9075), new LatLng(22.81805, 104.7319),
                        new LatLng(22.6875, 104.3747), new LatLng(22.79812, 104.1113),
                        new LatLng(22.50387, 103.9687), new LatLng(22.78287, 103.6538),
                        new LatLng(22.58436, 103.5224), new LatLng(22.79451, 103.3337),
                        new LatLng(22.43652, 103.0304), new LatLng(22.77187, 102.4744),
                        new LatLng(22.39629, 102.1407), new LatLng(22.49777, 101.7415),
                        new LatLng(22.20916, 101.5744), new LatLng(21.83444, 101.7653),
                        new LatLng(21.14451, 101.786), new LatLng(21.17687, 101.2919),
                        new LatLng(21.57264, 101.1482), new LatLng(21.76903, 101.099),
                        new LatLng(21.47694, 100.6397), new LatLng(21.43546, 100.2057),
                        new LatLng(21.72555, 99.97763), new LatLng(22.05018, 99.95741),
                        new LatLng(22.15592, 99.16785), new LatLng(22.93659, 99.56484),
                        new LatLng(23.08204, 99.5113), new LatLng(23.18916, 98.92747),
                        new LatLng(23.97076, 98.67991), new LatLng(24.16007, 98.89073),
                        new LatLng(23.92999, 97.54762), new LatLng(24.26055, 97.7593),
                        new LatLng(24.47666, 97.54305), new LatLng(24.73992, 97.55255),
                        new LatLng(25.61527, 98.19109), new LatLng(25.56944, 98.36137),
                        new LatLng(25.85597, 98.7104), new LatLng(26.12527, 98.56944),
                        new LatLng(26.18472, 98.73109), new LatLng(26.79166, 98.77777),
                        new LatLng(27.52972, 98.69699), new LatLng(27.6725, 98.45888),
                        new LatLng(27.54014, 98.31992), new LatLng(28.14889, 98.14499),
                        new LatLng(28.54652, 97.55887), new LatLng(28.22277, 97.34888),
                        new LatLng(28.46749, 96.65387), new LatLng(28.35111, 96.40193),
                        new LatLng(28.525, 96.34027), new LatLng(28.79569, 96.61373),
                        new LatLng(29.05666, 96.47083), new LatLng(28.90138, 96.17532),
                        new LatLng(29.05972, 96.14888), new LatLng(29.25757, 96.39172),
                        new LatLng(28.10087, 96.206999), new LatLng(28.034588, 95.449213),
                        new LatLng(27.644672, 94.836515), new LatLng(27.53611, 94.32863),
                        new LatLng(26.971884, 93.829457),
                        new LatLng(28.24257, 90.38898), new LatLng(28.32369, 89.99819),
                        new LatLng(28.05777, 89.48749), new LatLng(27.32083, 88.91693)

                });

//        polygon.add(new LatLng[] // Taiwan
//                {new LatLng(25.13474, 121.4441), new LatLng(25.28361, 121.5632),
//                        new LatLng(25.00722, 122.0004), new LatLng(24.85028, 121.8182),
//                        new LatLng(24.47638, 121.8397), new LatLng(23.0875, 121.3556),
//                        new LatLng(21.92791, 120.7196), new LatLng(22.31277, 120.6103),
//                        new LatLng(22.54044, 120.3071), new LatLng(23.04437, 120.0539),
//                        new LatLng(23.61708, 120.1112), new LatLng(25.00166, 121.0017),
//                        new LatLng(25.13474, 121.4441)});
//
//        polygon.add(new LatLng[] // Hainan
//                {new LatLng(19.52888, 110.855), new LatLng(19.16761, 110.4832),
//                        new LatLng(18.80083, 110.5255), new LatLng(18.3852, 110.0503),
//                        new LatLng(18.39152, 109.7594), new LatLng(18.19777, 109.7036),
//                        new LatLng(18.50562, 108.6871), new LatLng(19.28028, 108.6283),
//                        new LatLng(19.76, 109.2939), new LatLng(19.7236, 109.1653),
//                        new LatLng(19.89972, 109.2572), new LatLng(19.82861, 109.4658),
//                        new LatLng(19.99389, 109.6108), new LatLng(20.13361, 110.6655),
//                        new LatLng(19.97861, 110.9425), new LatLng(19.63829, 111.0215),
//                        new LatLng(19.52888, 110.855)});
//
//        polygon.add(new LatLng[] // Chongming
//                {new LatLng(31.80054, 121.2039), new LatLng(31.49972, 121.8736),
//                        new LatLng(31.53111, 121.5464), new LatLng(31.80054, 121.2039)});
    }



    public static boolean CheckInChina(double lat, double lon) {
        for (LatLng[] mPoints : polygon) {
            if (IsInsidePolygon(mPoints, lat, lon)) {
                return true;
            }
        }
        return false;
    }
    public static boolean IsInsidePolygon(LatLng[] poly, double lat, double lon) {
        int index = 0;
        boolean inside = false;
        LatLng prePoint = poly[0];
        for (index = 1; index < poly.length; index++) {
            LatLng nextPoint = poly[index];
            if (lon > Math.min(prePoint.longitude, nextPoint.longitude)
                    && lon <= Math.max(prePoint.longitude, nextPoint.longitude)
                    && lat <= Math.max(prePoint.latitude, nextPoint.latitude)
                    && prePoint.longitude != nextPoint.longitude) {
                double xinters = (lon - prePoint.longitude)
                        * (nextPoint.latitude - prePoint.latitude)
                        / (nextPoint.longitude - prePoint.longitude) + prePoint.latitude;
                if (prePoint.latitude == nextPoint.latitude || lat <= xinters)
                    inside ^= true;
            }
            prePoint = nextPoint;
        }
        return inside;
    }


}