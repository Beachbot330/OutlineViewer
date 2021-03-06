package edu.wpi.first.outlineviewer.view.dialog;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;
import org.testfx.matcher.control.ListViewMatchers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class AddNumberArrayDialogTest extends AddEntryArrayDialogTest<AddNumberArrayDialog> {

  AddNumberArrayDialogTest() {
    super(AddNumberArrayDialog::new);
  }

  @Test
  @SuppressWarnings("unchecked")
  void testInitialValue() {
    final Double[] test = new Double[]{1.0, 5.5, 3.14, -19.01};
    dialog.setInitial(test);

    assertArrayEquals(test, ((ListView) lookup(".list-view").query()).getItems().toArray());
  }

  @Test
  @SuppressWarnings("unchecked")
  void testGetData() {
    final Double[] test = new Double[]{1.0, 5.5, 3.14, -19.01};
    dialog.setInitial(test);

    assertArrayEquals(test, dialog.getData());
  }

  @Test
  void testToStringConverter() {
    final double test = 654.321;
    ListView listView = lookup(ListViewMatchers.isEmpty()).query();
    clickOn("+");

    doubleClickOn((Node) from(listView).lookup(".list-cell").query()).press(KeyCode.DELETE)
        .write(String.valueOf(test)).type(KeyCode.ENTER);

    assertEquals(test, listView.getItems().get(0));
  }

}
