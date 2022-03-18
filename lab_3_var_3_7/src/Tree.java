import java.util.Arrays;
import java.util.Objects;

public class Tree {
  Leaf leafs[];
  TreeState state = TreeState.GROWING;

  public Tree() {
    leafs = new Leaf[25];

    for (int i = 0; i < 25; i++) {
      leafs[i] = new Leaf();
    }
  }

  public void YellowLeafs() {
    Arrays.stream(leafs)
      .forEach(c -> c.YellowLeaf());
  }

  public void Blossom() {
    state = TreeState.BLOSSOMING;
  }

  public void DropLeafs() {
    Arrays.fill(leafs, null);
  }

  public void GetSnowy() {
    Arrays.stream(leafs)
      .forEach(c -> c.SnowLeaf());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tree tree = (Tree) o;
    return state.equals(tree.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state);
  }

  @Override
  public String toString() {
      return "Tree{" +
              "state='" + state + '\'' +
              '}';
  }
}
