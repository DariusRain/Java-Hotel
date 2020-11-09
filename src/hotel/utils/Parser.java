package hotel.utils;

import hotel.rooms.Room;
import hotel.rooms.Types;
import hotel.rooms.Standard;
import hotel.rooms.Suite;
import java.util.ArrayList;
import java.util.Random;

public class Parser {
//    RoomTypes parseRoomType

//    public static <AnyRoom> AnyRoom parseRoom(Class<? extends Room> room) {
//
//    }

    public static <Any> Any getListChoice
            (Types type, ArrayList<Standard> possibilityStandard, ArrayList<Suite> possibilitySuite)
    {
        switch (type) {
            case SINGLE:
                return (Any)(possibilityStandard);
            case SUITE:
                return (Any)(possibilitySuite);
            default:
                return (Any)null;

        }
    }

    public static <Any> ArrayList<? extends Room> genericToList(Any toBeParsed) { return (ArrayList<? extends Room>)(toBeParsed); }

    public static <Any> Class<? extends Room> genericToRoom(Any toBeParsed) { return (Class<? extends Room >)(toBeParsed); }

}
