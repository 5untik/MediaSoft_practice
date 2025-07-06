public interface RoomService<T extends Room> {
    
    void clean(T room);
    
    void reserve(T room) throws RoomAlreadyBookedException;
    
    void free(T room);
}
