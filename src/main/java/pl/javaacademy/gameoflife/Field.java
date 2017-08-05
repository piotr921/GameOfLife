package pl.javaacademy.gameoflife;

class Field {
    private final int index;
    private final FieldType type;

    Field(int index, FieldType type) {
        this.index = index;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public FieldType getType() {
        return type;
    }
}
