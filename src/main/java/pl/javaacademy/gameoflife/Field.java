package pl.javaacademy.gameoflife;

class Field {
    private final int index;
    private final FieldType type;

    Field(int index, FieldType type) {
        this.index = index;
        this.type = type;
    }

    int getIndex() {
        return index;
    }

    FieldType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        return index == field.index;
    }

    @Override
    public int hashCode() {
        return index;
    }
}
