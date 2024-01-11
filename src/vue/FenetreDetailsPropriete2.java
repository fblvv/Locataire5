package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controle.GestionDetailPropriete2;
import controle.GestionListeLocataire;
import modele.BienImmobilier;
import modele.dao.DaoBienImmobilier;

public class FenetreDetailsPropriete2 extends JInternalFrame {
	
	private GestionDetailPropriete2 gestionClic;
    private JPanel contentPane;
    private JTextField champAdresse;
    private JTextField champType;
    private JTextField champCompteur;
    private JTextField champSurface;
    private JTextField champEquipements;
    private JTextField champDateDebut;
    private JTextField champDateFin;
    private JTextField champNombrePieces;
    private JTable tableLocataire;
    private JTextField champStatutOccupation;
    private JTextField champContratsServices;
    private JTextField champCommentaires;
    private JTable tablePaiements;
    private JTable tableHistorique;
    private JComboBox<String> selecteurIdBien;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreDetailsPropriete2 frame = new FenetreDetailsPropriete2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreDetailsPropriete2() {
    	setMaximizable(true);
    	setIconifiable(true);
    	setClosable(true);
    	this.gestionClic = new GestionDetailPropriete2(this);
        setBounds(100, 100, 720, 775);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 266, 40, 266 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 30 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0 };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0 };
        contentPane.setLayout(gbl_contentPane);
		
		JPanel panelGauche = new JPanel();
		GridBagConstraints gbc_panelGauche = new GridBagConstraints();
		gbc_panelGauche.fill = GridBagConstraints.BOTH;
		gbc_panelGauche.insets = new Insets(0, 0, 5, 5);
		gbc_panelGauche.gridx = 0;
		gbc_panelGauche.gridy = 0;
		contentPane.add(panelGauche, gbc_panelGauche);
		GridBagLayout gbl_panelGauche = new GridBagLayout();
		gbl_panelGauche.columnWidths = new int[]{114, 207, 0};
		gbl_panelGauche.rowHeights = new int[] {100, 0, 0, 0, 0, 0, 0, 0, 0, 30, 37, 75, 30, 0, 0, 0, 30};
		gbl_panelGauche.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelGauche.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelGauche.setLayout(gbl_panelGauche);
		
		JLabel labelTypeLogement = new JLabel("Type de Logement");
		labelTypeLogement.setToolTipText("");
		labelTypeLogement.setForeground(Color.BLACK);
		labelTypeLogement.setBackground(Color.LIGHT_GRAY);
		labelTypeLogement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_labelTypeLogement = new GridBagConstraints();
		gbc_labelTypeLogement.gridwidth = 2;
		gbc_labelTypeLogement.insets = new Insets(0, 0, 5, 0);
		gbc_labelTypeLogement.gridx = 0;
		gbc_labelTypeLogement.gridy = 0;
		panelGauche.add(labelTypeLogement, gbc_labelTypeLogement);
		
		JLabel labelAdresse = new JLabel("Adresse:");
		labelAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelAdresse = new GridBagConstraints();
		gbc_labelAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_labelAdresse.anchor = GridBagConstraints.WEST;
		gbc_labelAdresse.gridx = 0;
		gbc_labelAdresse.gridy = 1;
		panelGauche.add(labelAdresse, gbc_labelAdresse);
		
		champAdresse = new JTextField();
		champAdresse.setColumns(5);
		GridBagConstraints gbc_champAdresse = new GridBagConstraints();
		gbc_champAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_champAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_champAdresse.gridx = 1;
		gbc_champAdresse.gridy = 1;
		panelGauche.add(champAdresse, gbc_champAdresse);
		
		JLabel labelType = new JLabel("Type:");
		GridBagConstraints gbc_labelType = new GridBagConstraints();
		gbc_labelType.anchor = GridBagConstraints.WEST;
		gbc_labelType.insets = new Insets(0, 0, 5, 5);
		gbc_labelType.gridx = 0;
		gbc_labelType.gridy = 2;
		panelGauche.add(labelType, gbc_labelType);
		
		champType = new JTextField();
		champType.setColumns(5);
		GridBagConstraints gbc_champType = new GridBagConstraints();
		gbc_champType.insets = new Insets(0, 0, 5, 0);
		gbc_champType.fill = GridBagConstraints.HORIZONTAL;
		gbc_champType.gridx = 1;
		gbc_champType.gridy = 2;
		panelGauche.add(champType, gbc_champType);
		
		JLabel labelNombreCompteurs = new JLabel("Nombre de Compteurs:");
		GridBagConstraints gbc_labelNombreCompteurs = new GridBagConstraints();
		gbc_labelNombreCompteurs.anchor = GridBagConstraints.WEST;
		gbc_labelNombreCompteurs.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombreCompteurs.gridx = 0;
		gbc_labelNombreCompteurs.gridy = 3;
		panelGauche.add(labelNombreCompteurs, gbc_labelNombreCompteurs);
		
		champCompteur = new JTextField();
		champCompteur.setColumns(5);
		GridBagConstraints gbc_champCompteur = new GridBagConstraints();
		gbc_champCompteur.insets = new Insets(0, 0, 5, 0);
		gbc_champCompteur.fill = GridBagConstraints.HORIZONTAL;
		gbc_champCompteur.gridx = 1;
		gbc_champCompteur.gridy = 3;
		panelGauche.add(champCompteur, gbc_champCompteur);
		
		JLabel labelSurface = new JLabel("Surface:");
		GridBagConstraints gbc_labelSurface = new GridBagConstraints();
		gbc_labelSurface.anchor = GridBagConstraints.WEST;
		gbc_labelSurface.insets = new Insets(0, 0, 5, 5);
		gbc_labelSurface.gridx = 0;
		gbc_labelSurface.gridy = 4;
		panelGauche.add(labelSurface, gbc_labelSurface);
		
		champSurface = new JTextField();
		champSurface.setColumns(5);
		GridBagConstraints gbc_champSurface = new GridBagConstraints();
		gbc_champSurface.insets = new Insets(0, 0, 5, 0);
		gbc_champSurface.fill = GridBagConstraints.HORIZONTAL;
		gbc_champSurface.gridx = 1;
		gbc_champSurface.gridy = 4;
		panelGauche.add(champSurface, gbc_champSurface);
		
		JLabel labelNombrePieces = new JLabel("Nombre de Pièces:");
		GridBagConstraints gbc_labelNombrePieces = new GridBagConstraints();
		gbc_labelNombrePieces.anchor = GridBagConstraints.WEST;
		gbc_labelNombrePieces.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombrePieces.gridx = 0;
		gbc_labelNombrePieces.gridy = 5;
		panelGauche.add(labelNombrePieces, gbc_labelNombrePieces);
		
		champNombrePieces = new JTextField();
		champNombrePieces.setColumns(5);
		GridBagConstraints gbc_champNombrePieces = new GridBagConstraints();
		gbc_champNombrePieces.insets = new Insets(0, 0, 5, 0);
		gbc_champNombrePieces.fill = GridBagConstraints.HORIZONTAL;
		gbc_champNombrePieces.gridx = 1;
		gbc_champNombrePieces.gridy = 5;
		panelGauche.add(champNombrePieces, gbc_champNombrePieces);
		
		JLabel labelEquipements = new JLabel("Équipements:");
		GridBagConstraints gbc_labelEquipements = new GridBagConstraints();
		gbc_labelEquipements.anchor = GridBagConstraints.WEST;
		gbc_labelEquipements.insets = new Insets(0, 0, 5, 5);
		gbc_labelEquipements.gridx = 0;
		gbc_labelEquipements.gridy = 6;
		panelGauche.add(labelEquipements, gbc_labelEquipements);
		
		champEquipements = new JTextField();
		champEquipements.setColumns(5);
		GridBagConstraints gbc_champEquipements = new GridBagConstraints();
		gbc_champEquipements.insets = new Insets(0, 0, 5, 0);
		gbc_champEquipements.fill = GridBagConstraints.HORIZONTAL;
		gbc_champEquipements.gridx = 1;
		gbc_champEquipements.gridy = 6;
		panelGauche.add(champEquipements, gbc_champEquipements);
		
		JLabel labelDateDebut = new JLabel("Date de Début:");
		GridBagConstraints gbc_labelDateDebut = new GridBagConstraints();
		gbc_labelDateDebut.anchor = GridBagConstraints.WEST;
		gbc_labelDateDebut.insets = new Insets(0, 0, 5, 5);
		gbc_labelDateDebut.gridx = 0;
		gbc_labelDateDebut.gridy = 7;
		panelGauche.add(labelDateDebut, gbc_labelDateDebut);
		
		champDateDebut = new JTextField();
		champDateDebut.setColumns(5);
		GridBagConstraints gbc_champDateDebut = new GridBagConstraints();
		gbc_champDateDebut.insets = new Insets(0, 0, 5, 0);
		gbc_champDateDebut.fill = GridBagConstraints.HORIZONTAL;
		gbc_champDateDebut.gridx = 1;
		gbc_champDateDebut.gridy = 7;
		panelGauche.add(champDateDebut, gbc_champDateDebut);
		
		JLabel labelDateFin = new JLabel("Date de Fin:");
		GridBagConstraints gbc_labelDateFin = new GridBagConstraints();
		gbc_labelDateFin.anchor = GridBagConstraints.WEST;
		gbc_labelDateFin.insets = new Insets(0, 0, 5, 5);
		gbc_labelDateFin.gridx = 0;
		gbc_labelDateFin.gridy = 8;
		panelGauche.add(labelDateFin, gbc_labelDateFin);
		
		champDateFin = new JTextField();
		champDateFin.setColumns(5);
		GridBagConstraints gbc_champDateFin = new GridBagConstraints();
		gbc_champDateFin.insets = new Insets(0, 0, 5, 0);
		gbc_champDateFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_champDateFin.gridx = 1;
		gbc_champDateFin.gridy = 8;
		panelGauche.add(champDateFin, gbc_champDateFin);
		
		JLabel labelLocatairesActuels = new JLabel("Locataires Actuels");
		labelLocatairesActuels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLocatairesActuels.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelLocatairesActuels = new GridBagConstraints();
		gbc_labelLocatairesActuels.anchor = GridBagConstraints.WEST;
		gbc_labelLocatairesActuels.insets = new Insets(0, 0, 5, 5);
		gbc_labelLocatairesActuels.gridx = 0;
		gbc_labelLocatairesActuels.gridy = 10;
		panelGauche.add(labelLocatairesActuels, gbc_labelLocatairesActuels);
		
		JScrollPane scrollPaneLocatairesActuels = new JScrollPane((Component) null);
		GridBagConstraints gbc_scrollPaneLocatairesActuels = new GridBagConstraints();
		gbc_scrollPaneLocatairesActuels.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneLocatairesActuels.gridwidth = 2;
		gbc_scrollPaneLocatairesActuels.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLocatairesActuels.gridx = 0;
		gbc_scrollPaneLocatairesActuels.gridy = 11;
		panelGauche.add(scrollPaneLocatairesActuels, gbc_scrollPaneLocatairesActuels);
		
		tableLocataire = new JTable();
		tableLocataire.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nom", "Durée du séjour"
			}
		));
		scrollPaneLocatairesActuels.setViewportView(tableLocataire);
		
		JLabel labelStatutOccupation = new JLabel("Statut d'Occupation:");
		GridBagConstraints gbc_labelStatutOccupation = new GridBagConstraints();
		gbc_labelStatutOccupation.anchor = GridBagConstraints.WEST;
		gbc_labelStatutOccupation.insets = new Insets(0, 0, 5, 5);
		gbc_labelStatutOccupation.gridx = 0;
		gbc_labelStatutOccupation.gridy = 13;
		panelGauche.add(labelStatutOccupation, gbc_labelStatutOccupation);
		
		champStatutOccupation = new JTextField();
		champStatutOccupation.setColumns(5);
		GridBagConstraints gbc_champStatutOccupation = new GridBagConstraints();
		gbc_champStatutOccupation.insets = new Insets(0, 0, 5, 0);
		gbc_champStatutOccupation.fill = GridBagConstraints.HORIZONTAL;
		gbc_champStatutOccupation.gridx = 1;
		gbc_champStatutOccupation.gridy = 13;
		panelGauche.add(champStatutOccupation, gbc_champStatutOccupation);
		
		JLabel labelContratsServices = new JLabel("Contrats de Services:");
		GridBagConstraints gbc_labelContratsServices = new GridBagConstraints();
		gbc_labelContratsServices.anchor = GridBagConstraints.WEST;
		gbc_labelContratsServices.insets = new Insets(0, 0, 5, 5);
		gbc_labelContratsServices.gridx = 0;
		gbc_labelContratsServices.gridy = 14;
		panelGauche.add(labelContratsServices, gbc_labelContratsServices);
		
		champContratsServices = new JTextField();
		GridBagConstraints gbc_champContratsServices = new GridBagConstraints();
		gbc_champContratsServices.insets = new Insets(0, 0, 5, 0);
		gbc_champContratsServices.fill = GridBagConstraints.HORIZONTAL;
		gbc_champContratsServices.gridx = 1;
		gbc_champContratsServices.gridy = 14;
		panelGauche.add(champContratsServices, gbc_champContratsServices);
		champContratsServices.setColumns(10);
		
		JLabel labelCommentaires = new JLabel("Commentaires:");
		GridBagConstraints gbc_labelCommentaires = new GridBagConstraints();
		gbc_labelCommentaires.anchor = GridBagConstraints.WEST;
		gbc_labelCommentaires.insets = new Insets(0, 0, 0, 5);
		gbc_labelCommentaires.gridx = 0;
		gbc_labelCommentaires.gridy = 15;
		panelGauche.add(labelCommentaires, gbc_labelCommentaires);
		
		champCommentaires = new JTextField();
		GridBagConstraints gbc_champCommentaires = new GridBagConstraints();
		gbc_champCommentaires.fill = GridBagConstraints.HORIZONTAL;
		gbc_champCommentaires.gridx = 1;
		gbc_champCommentaires.gridy = 15;
		panelGauche.add(champCommentaires, gbc_champCommentaires);
		champCommentaires.setColumns(10);
		
		JPanel panelDroite = new JPanel();
	    GridBagConstraints gbc_panelDroite = new GridBagConstraints();
	    gbc_panelDroite.insets = new Insets(0, 0, 5, 0);
	    gbc_panelDroite.fill = GridBagConstraints.BOTH;
	    gbc_panelDroite.gridx = 2;
	    gbc_panelDroite.gridy = 0;
	    contentPane.add(panelDroite, gbc_panelDroite);
	    GridBagLayout gbl_panelDroite = new GridBagLayout();
	    gbl_panelDroite.columnWidths = new int[]{0, 0};
	    gbl_panelDroite.rowHeights = new int[]{0, 30, 30, 60, 0, 0, 0, 30, 30, 30, 0};
	    gbl_panelDroite.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	    gbl_panelDroite.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panelDroite.setLayout(gbl_panelDroite);
        
	 // Ajout de la JComboBox pour les ID bien
        selecteurIdBien = new JComboBox<>();
        GridBagConstraints gbc_selecteurIdBien = new GridBagConstraints();
        gbc_selecteurIdBien.ipady = 15;
        gbc_selecteurIdBien.gridheight = 2;
        gbc_selecteurIdBien.fill = GridBagConstraints.HORIZONTAL;
        gbc_selecteurIdBien.insets = new Insets(0, 0, 5, 0);
        gbc_selecteurIdBien.gridx = 0;
        gbc_selecteurIdBien.gridy = 0;
        panelDroite.add(selecteurIdBien, gbc_selecteurIdBien);
        
        
        
        
        initComboBox();
        
        
        
        
        JLabel labelHistoriquePaiements_1 = new JLabel("Historique des Paiements:");
        labelHistoriquePaiements_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelHistoriquePaiements_1 = new GridBagConstraints();
        gbc_labelHistoriquePaiements_1.anchor = GridBagConstraints.WEST;
        gbc_labelHistoriquePaiements_1.insets = new Insets(0, 0, 5, 0);
        gbc_labelHistoriquePaiements_1.gridx = 0;
        gbc_labelHistoriquePaiements_1.gridy = 2;
        panelDroite.add(labelHistoriquePaiements_1, gbc_labelHistoriquePaiements_1);
        
        JScrollPane scrollPaneHistoriquePaiements_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPaneHistoriquePaiements_1 = new GridBagConstraints();
        gbc_scrollPaneHistoriquePaiements_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneHistoriquePaiements_1.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPaneHistoriquePaiements_1.gridx = 0;
        gbc_scrollPaneHistoriquePaiements_1.gridy = 3;
        panelDroite.add(scrollPaneHistoriquePaiements_1, gbc_scrollPaneHistoriquePaiements_1);
        
        tablePaiements = new JTable();
        tablePaiements.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},

        	},
        	new String[] {
        		"Date", "Montant", "Mode de paiement"
        	}
        ));
        scrollPaneHistoriquePaiements_1.setViewportView(tablePaiements);
        
        JLabel labelHistoriqueReparations_1 = new JLabel("Historique des Réparations:");
        labelHistoriqueReparations_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelHistoriqueReparations_1 = new GridBagConstraints();
        gbc_labelHistoriqueReparations_1.anchor = GridBagConstraints.WEST;
        gbc_labelHistoriqueReparations_1.insets = new Insets(0, 0, 5, 0);
        gbc_labelHistoriqueReparations_1.gridx = 0;
        gbc_labelHistoriqueReparations_1.gridy = 5;
        panelDroite.add(labelHistoriqueReparations_1, gbc_labelHistoriqueReparations_1);
        
        JScrollPane scrollPaneHistoriqueReparations_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPaneHistoriqueReparations_1 = new GridBagConstraints();
        gbc_scrollPaneHistoriqueReparations_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneHistoriqueReparations_1.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPaneHistoriqueReparations_1.gridx = 0;
        gbc_scrollPaneHistoriqueReparations_1.gridy = 6;
        panelDroite.add(scrollPaneHistoriqueReparations_1, gbc_scrollPaneHistoriqueReparations_1);
        
        tableHistorique = new JTable();
        tableHistorique.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Date", "Description", "Co\u00FBt"
        	}
        ));
        scrollPaneHistoriqueReparations_1.setViewportView(tableHistorique);
        
        JPanel panelButton = new JPanel();
        GridBagConstraints gbc_panelButton = new GridBagConstraints();
        gbc_panelButton.insets = new Insets(0, 0, 5, 5);
        gbc_panelButton.fill = GridBagConstraints.BOTH;
        gbc_panelButton.gridx = 0;
        gbc_panelButton.gridy = 2;
        contentPane.add(panelButton, gbc_panelButton);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
        panelButton.add(btnAnnuler);
        btnAnnuler.addActionListener(this.gestionClic);
        
        JButton btnAutreSection = new JButton("Autre Section");
        btnAutreSection.setHorizontalAlignment(SwingConstants.RIGHT);
        panelButton.add(btnAutreSection);
    }
    
    
    private void initComboBox() {
        DaoBienImmobilier daoBienImmobilier = new DaoBienImmobilier();
        try {
 
            Collection<BienImmobilier> biens = daoBienImmobilier.findAll();


            String[] ids = new String[biens.size()];

            int i = 0;
            for (BienImmobilier bien : biens) {
                ids[i] = bien.getId_Bien_Imm();
                i++;
            }


            selecteurIdBien.setModel(new DefaultComboBoxModel<>(ids));


            selecteurIdBien.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        gestionClic.afficherInfoLogement();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
          
                    }
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }

    
    
    
    public String getSelecteurIdBien() {
	    return (String) selecteurIdBien.getSelectedItem();
	   }

	public JTextField getChampAdresse() {
		return champAdresse;
	}

	public void setChampAdresse(String adresse) {
		this.champAdresse.setText(adresse);
	}

	public JTextField  getChampType() {
		return champType;
	}

	public void setChampType(JTextField champType) {
		this.champType = champType;
	}

	public JTextField getChampCompteur() {
		return champCompteur;
	}

	public void setChampCompteur(JTextField champCompteur) {
		this.champCompteur = champCompteur;
	}

	public JTextField getChampSurface() {
		return champSurface;
	}

	public void setChampSurface(JTextField champSurface) {
		this.champSurface = champSurface;
	}

	public JTextField getChampEquipements() {
		return champEquipements;
	}

	public void setChampEquipements(JTextField champEquipements) {
		this.champEquipements = champEquipements;
	}

	public JTextField getChampDateDebut() {
		return champDateDebut;
	}

	public void setChampDateDebut(JTextField champDateDebut) {
		this.champDateDebut = champDateDebut;
	}

	public JTextField getChampDateFin() {
		return champDateFin;
	}

	public void setChampDateFin(JTextField champDateFin) {
		this.champDateFin = champDateFin;
	}

	public JTextField getChampNombrePieces() {
		return champNombrePieces;
	}

	public void setChampNombrePieces(JTextField champNombrePieces) {
		this.champNombrePieces = champNombrePieces;
	}

	public JTextField getChampStatutOccupation() {
		return champStatutOccupation;
	}

	public void setChampStatutOccupation(JTextField champStatutOccupation) {
		this.champStatutOccupation = champStatutOccupation;
	}

	public JTextField getChampContratsServices() {
		return champContratsServices;
	}

	public void setChampContratsServices(JTextField champContratsServices) {
		this.champContratsServices = champContratsServices;
	}

	public JTextField getChampCommentaires() {
		return champCommentaires;
	}

	public void setChampCommentaires(JTextField champCommentaires) {
		this.champCommentaires = champCommentaires;
	}
	
	public JTable getTableLocataire() {
		return tableLocataire;
	}
	
	public JTable getTablePaiement() {
		return tablePaiements;
	}
	
	

}
