package diagram.util;

import java.util.ArrayList;
import java.util.List;

import model.util.Attribute;
import model.util.Operation;
import model.util.Type;

public class ClassParser {

	public static List<Attribute> parseAttributes(String txt) throws Exception {
		List<Attribute> attributes = new ArrayList<Attribute>();
		Attribute attribute;
		String[] lines;
		String[] att;

		if (txt.trim().isEmpty()) {
			return attributes;
		}

		lines = txt.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			att = line.split(":");
			if (att.length != 2) {
				throw new Exception(
						"Erro na formatação!\nCampo: Atributos\nLinha: " + line);
			}
			attribute = new Attribute(att[0], Type.getType(att[1]));
			attributes.add(attribute);
		}

		return attributes;
	}

	public static List<Operation> parseOperations(String txt) throws Exception {
		List<Operation> operations = new ArrayList<Operation>();
		Operation operation;
		String[] lines;
		String[] opp;

		if (txt.trim().isEmpty()) {
			return operations;
		}

		lines = txt.split("\n");

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			opp = line.split(":");
			opp[0] = opp[0].replace("(", "");
			opp[0] = opp[0].replace(")", "");
			if (opp.length != 2) {
				throw new Exception(
						"Erro na formatação!\nCampo: Operações\nLinha: " + line);
			}
			operation = new Operation(opp[0], Type.getType(opp[1]));
			operations.add(operation);
		}

		return operations;
	}

	public static String attributesToString(List<Attribute> attributes) {
		String txt;

		txt = "";

		for (int i = 0; i < attributes.size(); i++) {
			Attribute attribute = attributes.get(i);
			txt = txt.concat(attribute.toString()).concat("\n");
		}

		return txt;
	}

	public static String operationsToString(List<Operation> operations) {
		String txt;

		txt = "";

		for (int i = 0; i < operations.size(); i++) {
			Operation operation = operations.get(i);
			txt = txt.concat(operation.toString()).concat("\n");
		}

		return txt;
	}
}
