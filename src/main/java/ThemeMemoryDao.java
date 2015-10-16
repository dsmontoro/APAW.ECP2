public class ThemeMemoryDao extends GenericMemoryDao<Theme, Integer> implements ThemeDao {

    public ThemeMemoryDao() {
        this.setMap(new HashMap<Integer, Theme>());
    }

    @Override
    protected Integer getId(Theme entity) {
        return entity.getId();
    }

    @Override
    public Theme findByName(String themeName) {
        for (Theme theme : this.findAll()) {
            if (themeName.equals(theme.getName())) {
                return theme;
            }
        }
        return null;
    }

    @Override
    public List<String> findAllNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Theme theme : this.findAll()) {
            nameList.add(theme.getName());
        }
        return nameList;
    }

}
